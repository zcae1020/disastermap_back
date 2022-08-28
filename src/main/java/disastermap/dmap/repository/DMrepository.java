package disastermap.dmap.repository;

import disastermap.dmap.domain.DM;

import java.util.List;

public interface DMrepository {
    DM save(DM dm);
    DM findById(Long id);
    List<DM> findAll();
    List<DM> findValidAll();
    DM delete(Long id) throws CloneNotSupportedException;
    DM setUnvalid(Long id) throws CloneNotSupportedException;
}
