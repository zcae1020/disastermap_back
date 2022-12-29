package disastermap.dmap.controller;

import disastermap.dmap.domain.DM;
import disastermap.dmap.service.DMserviceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "https://disastermap.zcae1020.repl.co")
@Controller
public class apiController {

    private DMserviceInterface dMservice;

    @Autowired
    public apiController(DMserviceInterface dMservice) {
        this.dMservice = dMservice;
    }

    @ResponseBody
    @GetMapping("/api")
    public List<DM> dmApi() throws SQLException {
        List<DM> list = dMservice.findValidDMs();
        return list;
    }
}
