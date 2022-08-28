package disastermap.dmap.service;

import disastermap.dmap.domain.DM;
import disastermap.dmap.repository.dCode;
import org.json.JSONArray;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface DMserviceInterface {
    Long join(DM dm);
    List<DM> findDMs();
    List<DM> findValidDMs();
    DM findDM(Long id);
    DM delDM(Long id) throws CloneNotSupportedException;
    DM unvaildDM(Long id) throws CloneNotSupportedException;
    Set<dCode> getdCodes() throws IOException;
}
