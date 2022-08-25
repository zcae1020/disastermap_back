package disastermap.dmap.controller;

import disastermap.dmap.domain.DM;
import disastermap.dmap.service.DMservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class homeController {

    DMservice dMservice;

    @Autowired
    public homeController(DMservice dMservice) {
        this.dMservice = dMservice;
    }

    @GetMapping("/")
    public String home(Model model){
        List<DM> list = dMservice.findDMs();
        model.addAttribute("dms", list);

        return "home";
    }
}
