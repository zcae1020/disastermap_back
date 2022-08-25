package disastermap.dmap.service;

import disastermap.dmap.domain.DM;
import disastermap.dmap.repository.DMrepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DMservice {

    private final DMrepository dMrepository;

    public DMservice(DMrepository dMrepository) {
        this.dMrepository = dMrepository;
    }

    public Long join(DM dm){
        DM res = dMrepository.save(dm);
        return (res==null?0:res.getId());
    }

    public List<DM> findDMs(){
        return dMrepository.findAll();
    }
}
