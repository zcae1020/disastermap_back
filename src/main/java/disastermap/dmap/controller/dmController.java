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
    public String createDM(dmForm dmform) throws IOException {
        if(!isValidDmform(dmform)){
            System.out.println("isunValid");
            return "DMpage/DMsubmit";
        }

        DM dm = new DM();

        LatLng latLng = new LatLng(Double.parseDouble(dmform.getX()), Double.parseDouble(dmform.getY()));
        KakaoPlace kakaoPlace = new KakaoPlace();
        kakaoPlace.setPlace(dmform.getPlace());
        kakaoPlace.setAddress(dmform.getAddress());
        kakaoPlace.setLatLng(latLng);

        dm.setDisasterCode(dmform.getdCode());
        dm.setContent(dmform.getContent());
        dm.setDate(new Date());
        dm.setValid(true);
        dm.setKakaoPlace(kakaoPlace);

        dMservice.join(dm);

        return "redirect:/";
    }

    private boolean isValidDmform(dmForm dmform) throws IOException {
        if(dmform.getAddress()==""||dmform.getContent()=="")
            return false;

        for(dCode code:dMservice.getdCodes())
            if(code.getCodeNum().equals(dmform.getdCode()))
                return true;

        return false;
    }
}
