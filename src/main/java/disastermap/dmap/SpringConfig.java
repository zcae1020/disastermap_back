package disastermap.dmap;

import disastermap.dmap.repository.DMmemoryRepository;
import disastermap.dmap.repository.DMrepository;
import disastermap.dmap.service.DMservice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public DMrepository dMrepository(){
        return new DMmemoryRepository();
    }

    @Bean
    public DMservice dMservice(DMrepository dMrepository){
        return new DMservice(dMrepository);
    }
}
