package disastermap.dmap.service;

import disastermap.dmap.domain.DM;
import disastermap.dmap.repository.DMrepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class serviceTest {

    @Autowired DMservice dMservice;
    @Autowired DMrepository dMrepository;

    @Test
    void join(){
        DM dm = new DM();
        dm.setContent("침수");
        dm.setPlace("경부고속도로");
        dm.setDisasterCode("02");
        dm.setLatLng(new double[]{13, 23});

        Long id = dMservice.join(dm);

        Assertions.assertThat(dm).isEqualTo(dMrepository.findById(id));
    }
}