package disastermap.dmap.controller;

import disastermap.dmap.domain.DM;
import disastermap.dmap.service.DMservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "https://disastermap.zcae1020.repl.co")
@Controller
public class apiController {

    DMservice dMservice;

    @Autowired
    public apiController(DMservice dMservice) {
        this.dMservice = dMservice;
    }

    @ResponseBody
    @GetMapping("/api")
    public List<DM> dmApi(){
        List<DM> list = dMservice.findDMs();
        System.out.println(list);
        return list;
    }
}
