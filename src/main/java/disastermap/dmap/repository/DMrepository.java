package disastermap.dmap.repository;

import disastermap.dmap.domain.DM;

import java.util.List;

public interface DMrepository {
    DM save(DM dm);
    List<DM> findAll();
}
