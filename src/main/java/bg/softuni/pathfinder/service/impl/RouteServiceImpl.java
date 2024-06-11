package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.models.Picture;
import bg.softuni.pathfinder.models.Route;
import bg.softuni.pathfinder.models.dtos.RouteInfoDto;
import bg.softuni.pathfinder.repository.RouteRepository;
import bg.softuni.pathfinder.service.RouteService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {
    private final RouteRepository routeRepository;
    private final ModelMapper modelMapper;

    public RouteServiceImpl(RouteRepository routeRepository, ModelMapper modelMapper) {
        this.routeRepository = routeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public List<RouteInfoDto> getAllRoutes() {
        List<RouteInfoDto> routes = new ArrayList<>();
        for (Route route : routeRepository.findAll()) {
            RouteInfoDto routeInfoDto = modelMapper.map(route, RouteInfoDto.class);
            Picture picture = route.getPictures().stream().findFirst().get();
            routeInfoDto.setPictureUrl(picture.getUrl());
            routes.add(routeInfoDto);
        }
        return routes;
    }
}
