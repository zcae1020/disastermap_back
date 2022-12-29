package disastermap.dmap;

import disastermap.dmap.repository.DMmemoryRepository;
import disastermap.dmap.repository.DMrepository;
import disastermap.dmap.repository.JDBCrepo;
import disastermap.dmap.repository.dCodeSet;
import disastermap.dmap.service.DMserviceDcodeClass;
import disastermap.dmap.service.DMserviceInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

@Configuration
public class SpringConfig {

    @Bean
    public DMrepository dMrepository() throws SQLException {
        return new JDBCrepo();
    }

    @Bean
    public dCodeSet dCodeSet() {
        return new dCodeSet();
    }

    @Bean
    public DMserviceInterface dMservice(DMrepository dMrepository, dCodeSet codeSet) {
        return new DMserviceDcodeClass(dMrepository, codeSet);
    }
}
