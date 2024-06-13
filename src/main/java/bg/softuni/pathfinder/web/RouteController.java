package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.models.dtos.RouteInfoDto;
import bg.softuni.pathfinder.service.CurrentUser;
import bg.softuni.pathfinder.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RouteController {
    private final RouteService routeService;
    private final CurrentUser currentUser;

    public RouteController(RouteService routeService, CurrentUser currentUser) {
        this.routeService = routeService;
        this.currentUser = currentUser;
    }

    @GetMapping("/routes")
    public ModelAndView rotes(ModelAndView mav){
        List<RouteInfoDto> allRoutes = routeService.getAllRoutes();
        mav.addObject("allRoutes", allRoutes);
        mav.setViewName("routes");
        return mav;
    }
    @ModelAttribute("isLoggedIn")
    public boolean isLoggedIn() {
        return currentUser.isLoggedIn();
    }
}
