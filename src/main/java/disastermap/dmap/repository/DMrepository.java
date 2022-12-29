package disastermap.dmap.repository;

import disastermap.dmap.domain.DM;

import java.sql.SQLException;
import java.util.List;

public interface DMrepository {
    DM save(DM dm) throws SQLException;
    DM findById(Long id) throws SQLException;
    List<DM> findAll() throws SQLException;
    List<DM> findValidAll() throws SQLException;
    DM delete(Long id) throws CloneNotSupportedException, SQLException;
    DM setUnvalid(Long id) throws CloneNotSupportedException, SQLException;
}
