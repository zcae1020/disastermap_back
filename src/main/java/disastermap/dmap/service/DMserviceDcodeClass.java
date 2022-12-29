package disastermap.dmap.service;

import disastermap.dmap.domain.DM;
import disastermap.dmap.repository.DMrepository;
import disastermap.dmap.repository.dCode;
import disastermap.dmap.repository.dCodeSet;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class DMserviceDcodeClass implements DMserviceInterface {
    private final DMrepository dMrepository;
    private final dCodeSet dCodeSet;

    public DMserviceDcodeClass(DMrepository dMrepository, dCodeSet codeSet) {
        this.dMrepository = dMrepository;
        this.dCodeSet = codeSet;
    }

    public Long join(DM dm) throws SQLException {
        //validate
        DM res = dMrepository.save(dm);
        return (res == null ? 0 : res.getId());
    }

    public List<DM> findDMs() throws SQLException {
        return dMrepository.findAll();
    }

    public List<DM> findValidDMs() throws SQLException {
        return dMrepository.findValidAll();
    }

    public DM findDM(Long id) throws SQLException {
        return dMrepository.findById(id);
    }

    public DM delDM(Long id) throws CloneNotSupportedException, SQLException {
        return dMrepository.delete(id);
    }

    public DM unvaildDM(Long id) throws CloneNotSupportedException, SQLException {
        return dMrepository.setUnvalid(id);
    }

    public Set<dCode> getdCodes() {
        return dCodeSet.getdCodeSet();
    }
}
