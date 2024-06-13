package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.models.dtos.UserRegisterDto;
import bg.softuni.pathfinder.models.dtos.UserLoginDto;
import bg.softuni.pathfinder.models.enums.Level;
import bg.softuni.pathfinder.service.CurrentUser;
import bg.softuni.pathfinder.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final CurrentUser currentUser;

    public UserController(UserService userService, CurrentUser currentUser) {
        this.userService = userService;
        this.currentUser = currentUser;
    }

    @GetMapping("/register")
    public String viewRegister(Model model){
        if (!model.containsAttribute("userRegisterDto")){
            model.addAttribute("userRegisterDto", new UserRegisterDto());
        }
        model.addAttribute("levels", Level.values());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid UserRegisterDto userRegisterDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("userRegisterDto", userRegisterDto);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.userRegisterDto", bindingResult);
            return "redirect:/users/register";
        }
        userService.register(userRegisterDto);
        redirectAttributes.addFlashAttribute("userData", userService.mapRegisterUser(userRegisterDto));
        return "redirect:/users/login";
    }
    @GetMapping("/login")
    public String viewLogin(Model model){
        if (!model.containsAttribute("userData")){
            model.addAttribute("userData", new UserLoginDto());
        }
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(UserLoginDto userLoginDto, RedirectAttributes redirectAttributes){
        boolean isLogged = userService.loginUser(userLoginDto);
        if (isLogged){
            return "redirect:/";
        }
        redirectAttributes.addFlashAttribute("loginError", "Invalid username or password");

        return "redirect:/users/login";
    }

    @ModelAttribute("isLoggedIn")
    public boolean isLoggedIn() {
        return currentUser.isLoggedIn();
    }

}
