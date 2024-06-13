package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.service.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Random;

@Controller
public class HomeController {
    private final CurrentUser currentUser;

    public HomeController(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    @GetMapping("/")
    public String home(Model model){
        Random random = new Random();
        double randomC = 5.5;
        model.addAttribute("degrees", randomC);
        return "index";
    }
    @ModelAttribute("isLoggedIn")
    public boolean isLoggedIn() {
        return currentUser.isLoggedIn();
    }
}
