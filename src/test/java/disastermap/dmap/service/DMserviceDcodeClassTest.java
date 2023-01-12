package disastermap.dmap.service;

import disastermap.dmap.domain.DM;
import disastermap.dmap.domain.LatLng;
import disastermap.dmap.repository.DMrepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional // test시 db에 영향을 주는 것을 test에만 사용하고 다 끝나면 다시 rollback, @Commit을 사용하면 transactional 영향x, @rollback과의 차이는?
class DMserviceDcodeClassTest {

    @Autowired
    DMserviceInterface dMservice;

    @Autowired
    DMrepository dMrepository;
    @Test
    void join() throws SQLException {

        DM dm = new DM("02", "홍수", "서울대", "서울대 주소", new LatLng(126.231, 35.89));

        Long id = dMservice.join(dm);

        dm.setId(id);

        DM newDm = dMservice.findDM(id);

        dm.setDate(new Date(15));
        newDm.setDate(new Date(15));

        Assertions.assertThat(dm).usingRecursiveComparison().isEqualTo(newDm);
    }

    @Test
    void findAll() throws SQLException {
        DM dm = new DM("02", "홍수", "서울대", "서울대 주소", new LatLng(126.231, 35.89));

        Long id = dMservice.join(dm);

        dm.setId(id);

        List<DM> dMs = dMservice.findDMs();

        DM lastDm = dMs.get(dMs.size() - 1);

        dm.setDate(new Date(15));
        lastDm.setDate(new Date(15));

        Assertions.assertThat(dm).usingRecursiveComparison().isEqualTo(lastDm);
    }

    @Test
    void findValidDMs() throws SQLException, CloneNotSupportedException {
        DM dm = new DM("02", "홍수", "서울대", "서울대 주소", new LatLng(126.231, 35.89));

        Long id = dMservice.join(dm);

        dm.setId(id);

        List<DM> dMs = dMservice.findValidDMs();

        DM lastDm = dMs.get(dMs.size() - 1);

        dm.setDate(new Date(15));
        lastDm.setDate(new Date(15));

        Assertions.assertThat(dm).usingRecursiveComparison().isEqualTo(lastDm);

        dMservice.unvaildDM(id);

        dMs = dMservice.findValidDMs();

        lastDm = dMs.get(dMs.size() - 1);

        dm.setDate(new Date(15));
        lastDm.setDate(new Date(15));

        Assertions.assertThat(dm).usingRecursiveComparison().isNotEqualTo(lastDm);
    }

    @Test
    void delDM() throws SQLException, CloneNotSupportedException {
        DM dm = new DM("02", "홍수", "서울대", "서울대 주소", new LatLng(126.231, 35.89));

        Long id = dMservice.join(dm);

        dm.setId(id);

        List<DM> dMs = dMservice.findDMs();

        DM lastDm = dMs.get(dMs.size() - 1);

        dm.setDate(new Date(15));
        lastDm.setDate(new Date(15));

        Assertions.assertThat(dm).usingRecursiveComparison().isEqualTo(lastDm);

        DM delDm = dMservice.delDM(id);

        delDm.setDate(new Date(15));

        Assertions.assertThat(dm).usingRecursiveComparison().isEqualTo(delDm);
    }
}