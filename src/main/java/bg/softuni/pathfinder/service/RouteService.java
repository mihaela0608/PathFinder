package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.models.dtos.RouteInfoDto;

import java.util.List;

public interface RouteService {
    List<RouteInfoDto> getAllRoutes();
}
