package disastermap.dmap.service;

import disastermap.dmap.domain.DM;
import disastermap.dmap.repository.dCode;
import org.json.JSONArray;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface DMserviceInterface {
    Long join(DM dm) throws SQLException;
    List<DM> findDMs() throws SQLException;
    List<DM> findValidDMs() throws SQLException;
    DM findDM(Long id) throws SQLException;
    DM delDM(Long id) throws CloneNotSupportedException, SQLException;
    DM unvaildDM(Long id) throws CloneNotSupportedException, SQLException;
    Set<dCode> getdCodes() throws IOException;
}
