package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.models.dtos.RouteInfoDto;
import bg.softuni.pathfinder.service.RouteService;
import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RouteController {
    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/routes")
    public ModelAndView rotes(ModelAndView mav){
        List<RouteInfoDto> allRoutes = routeService.getAllRoutes();
        mav.addObject("allRoutes", allRoutes);
        mav.setViewName("routes");
        return mav;
    }
}
