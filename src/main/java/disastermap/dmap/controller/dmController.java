package disastermap.dmap.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import disastermap.dmap.domain.DM;
import disastermap.dmap.service.DMservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class dmController {

    DMservice dMservice;

    @Autowired
    public dmController(DMservice dMservice) {
        this.dMservice = dMservice;
    }

    @GetMapping("/disasterMessage/new")
    public String createDMForm(){
        return "DMpage/DMsubmit";
    }

    @PostMapping("/disasterMessage/new")
    public String createDM(dmForm dmform) {
        DM dm = new DM();
        dm.setDisasterCode(dmform.getdCode());
        dm.setPlace(dmform.getPlace());
        dm.setContent(dmform.getContent());

        Date date = new Date();
        dm.setDate(date);

        System.out.println(dmform.toString()+'\n'+dm);

        dMservice.join(dm);

        return "redirect:/";
    }
}
