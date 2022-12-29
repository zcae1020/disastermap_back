package disastermap.dmap.controller;

import disastermap.dmap.service.DMservice;
import disastermap.dmap.service.DMserviceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
public class homeController {

    private DMserviceInterface dMservice;

    @Autowired
    public homeController(DMserviceInterface dMservice) {
        this.dMservice = dMservice;
    }

    @GetMapping("/")
    public String home(Model model) throws SQLException {
        model.addAttribute("dms", dMservice.findDMs());

        return "home";
    }

    @GetMapping("/content")
    public String dmContent(@RequestParam String dmId, Model model) throws SQLException {
        model.addAttribute("content", dMservice.findDM(Long.parseLong(dmId)).getContent());
        model.addAttribute("dmId", dmId);

        return "dmContent";
    }

    @PostMapping("/content/real")
    public String delDm(@RequestParam String dmId) throws CloneNotSupportedException, SQLException {
        dMservice.delDM(Long.parseLong(dmId));

        return "redirect:/";
    }

    @PostMapping("/content")
    public String unvalidDm(@RequestParam String dmId) throws CloneNotSupportedException, SQLException {
        dMservice.unvaildDM(Long.parseLong(dmId));

        return "redirect:/";
    }
}
