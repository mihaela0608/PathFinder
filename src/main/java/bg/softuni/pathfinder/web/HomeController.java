package bg.softuni.pathfinder.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model){
        Random random = new Random();
        double randomC = 5.5;
        model.addAttribute("degrees", randomC);
        return "index";
    }
}
