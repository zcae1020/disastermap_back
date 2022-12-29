package disastermap.dmap.repository;

import disastermap.dmap.domain.DM;
import disastermap.dmap.domain.LatLng;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCrepo implements DMrepository {

    private final Connection conn;

    public JDBCrepo() throws SQLException {
        String url = "jdbc:postgresql://127.0.0.1:5432/postgres";
        String id = "postgres";
        String pw = "1234";

        conn = DriverManager.getConnection(url, id, pw);
    }

    @Override
    public DM save(DM dm) throws SQLException {

        String sql = "insert into disaster(id, disastercode, contents, place, address, latitude, longitude, now, isValid) values (DEFAULT, ?,?,?,?,?,?,?,?) returning id";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, dm.getDisasterCode());
        stmt.setString(2, dm.getContent());
        stmt.setString(3, dm.getKakaoPlace().getPlace());
        stmt.setString(4, dm.getKakaoPlace().getAddress());
        stmt.setDouble(5, dm.getKakaoPlace().getLatLng().getX());
        stmt.setDouble(6, dm.getKakaoPlace().getLatLng().getY());
        stmt.setDate(7, dm.getDate());
        stmt.setBoolean(8, dm.isValid());

        ResultSet rs = stmt.executeQuery();

        rs.next();

        return findById(rs.getLong(1));
    }

    @Override
    public DM findById(Long id) throws SQLException {
        String sql = "select * from disaster where id=" + id ;

        ResultSet rs = conn.prepareStatement(sql).executeQuery();

        if(rs.next() == false) {
            return null;
        }

        LatLng latLng = new LatLng(rs.getDouble(6), rs.getDouble(7));

        DM disaster = new DM(rs.getLong(1), rs.getString(2),  rs.getString(3),  rs.getString(4),  rs.getString(5), latLng, rs.getDate(8), rs.getBoolean(9));

        return disaster;
    }

    @Override
    public List<DM> findAll() throws SQLException {
        List<DM> list = new ArrayList<>();

        String sql = "select * from disaster";

        ResultSet rs = conn.prepareStatement(sql).executeQuery();

        while(rs.next()) {
            LatLng latLng = new LatLng(rs.getDouble(6), rs.getDouble(7));
            DM disaster = new DM(rs.getLong(1), rs.getString(2),  rs.getString(3),  rs.getString(4),  rs.getString(5), latLng, rs.getDate(8), rs.getBoolean(9));
            list.add(disaster);
        }

        return list;
    }

    @Override
    public List<DM> findValidAll() throws SQLException {
        List<DM> list = new ArrayList<>();

        String sql = "select * from disaster where isvalid = true";

        ResultSet rs = conn.prepareStatement(sql).executeQuery();

        while(rs.next()) {
            LatLng latLng = new LatLng(rs.getDouble(6), rs.getDouble(7));
            DM disaster = new DM(rs.getLong(1), rs.getString(2),  rs.getString(3),  rs.getString(4),  rs.getString(5), latLng, rs.getDate(8), rs.getBoolean(9));
            list.add(disaster);
        }

        return list;
    }

    @Override
    public DM delete(Long id) throws CloneNotSupportedException, SQLException {
        DM dm = findById(id);

        String sql = "delete from disaster where id =" + id;

        conn.prepareStatement(sql).executeUpdate();

        return dm;
    }

    @Override
    public DM setUnvalid(Long id) throws CloneNotSupportedException, SQLException {
        String sql = "update disaster set isvalid = false where id =" +  id;

        conn.prepareStatement(sql).executeUpdate();

        return findById(id);
    }
}
