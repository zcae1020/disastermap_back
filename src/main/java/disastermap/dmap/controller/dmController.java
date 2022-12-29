package disastermap.dmap.controller;

import disastermap.dmap.domain.DM;
import disastermap.dmap.domain.KakaoPlace;
import disastermap.dmap.domain.LatLng;
import disastermap.dmap.repository.dCode;
import disastermap.dmap.service.DMservice;
import disastermap.dmap.service.DMserviceInterface;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.Set;

@Controller
public class dmController {

    private DMserviceInterface dMservice;

    @Autowired
    public dmController(DMserviceInterface dMservice) {
        this.dMservice = dMservice;
    }

    @GetMapping("/disasterMessage/new")
    public String createDMForm(){
        return "DMpage/DMsubmit";
    }

    @PostMapping("/disasterMessage/new")
    public String createDM(dmForm dmform) throws IOException, SQLException {
        if(!isValidDmform(dmform)){
            System.out.println("isunValid");
            return "DMpage/DMsubmit";
        }

        dMservice.join(new DM(
                dmform.getdCode(),
                dmform.getContent(),
                dmform.getPlace(),
                dmform.getAddress(),
                new LatLng(Double.parseDouble(dmform.getY()), Double.parseDouble(dmform.getX()))
        ));

        return "redirect:/";
    }

    private boolean isValidDmform(dmForm dmform) throws IOException {
        for(dCode code:dMservice.getdCodes())
            if(code.getCodeNum().equals(dmform.getdCode()))
                return true;

        return false;
    }
}
