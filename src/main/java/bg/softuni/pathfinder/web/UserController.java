package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.models.dtos.UserRegisterDto;
import bg.softuni.pathfinder.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users/register")
    public String viewRegister(Model model){
        if (!model.containsAttribute("userRegisterDto")){
            model.addAttribute("userRegisterDto", new UserRegisterDto());
        }
        return "register";
    }

    @PostMapping("users/register")
    public String registerUser(@Valid UserRegisterDto userRegisterDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("userRegisterDto", userRegisterDto);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.userRegisterDto", bindingResult);
            return "redirect:/users/register";
        }
        userService.register(userRegisterDto);

        return "redirect:/";
    }
}
