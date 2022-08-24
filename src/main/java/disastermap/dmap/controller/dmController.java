package disastermap.dmap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "https://disastermap.zcae1020.repl.co")
@Controller
public class dmController {

    @ResponseBody
    @GetMapping("/")
    public ArrayList<dmForm> dmApi() {
        ArrayList<dmForm> arrayList = new ArrayList<>();
        dmForm df = new dmForm();
        df.setName("name");

        arrayList.add(df);
        arrayList.add(new dmForm());

        return arrayList;
    }
}
