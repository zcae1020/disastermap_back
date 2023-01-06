package disastermap.dmap.service;

import disastermap.dmap.domain.DM;
import disastermap.dmap.domain.LatLng;
import disastermap.dmap.repository.DMrepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
public class serviceTest {

    @Autowired DMserviceInterface dMservice;
    @Autowired DMrepository dMrepository;

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
        DM dm = new DM("02", "침수", "서울대", "서울대 주소", new LatLng(126.231, 35.89));

        Long id = dMservice.join(dm);

        dm.setId(id);

        List<DM> dMs = dMservice.findDMs();

        DM lastDm = dMs.get(dMs.size() - 1);

        dm.setDate(new Date(15));
        lastDm.setDate(new Date(15));

        Assertions.assertThat(dm).usingRecursiveComparison().isEqualTo(lastDm);
    }


}