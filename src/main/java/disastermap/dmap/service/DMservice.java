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

    public DM join(DM dm){
        return dMrepository.save(dm);
    }

    public List<DM> getAllDM(){
        return dMrepository.findAll();
    }
}
