package disastermap.dmap.repository;

import disastermap.dmap.domain.DM;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DMmemoryRepository implements DMrepository{

    private ArrayList<DM> dmArrayList = new ArrayList<>();
    private Long ID = 0L;

    @Override
    public DM save(DM dm) {
        dm.setId(ID);
        dmArrayList.add(dm);
        return dm;
    }

    @Override
    public List<DM> findAll() {
        return dmArrayList;
    }
}
