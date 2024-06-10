package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.models.Picture;
import bg.softuni.pathfinder.models.Route;
import bg.softuni.pathfinder.models.dtos.RouteInfoDto;
import bg.softuni.pathfinder.repository.PictureRepository;
import bg.softuni.pathfinder.repository.RouteRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RouteServiceImpl implements RouteService{
    private final RouteRepository routeRepository;
    private final ModelMapper modelMapper;
    private final PictureRepository pictureRepository;

    public RouteServiceImpl(RouteRepository routeRepository, ModelMapper modelMapper, PictureRepository pictureRepository) {
        this.routeRepository = routeRepository;
        this.modelMapper = modelMapper;
        this.pictureRepository = pictureRepository;
    }

    @Override
    @Transactional
    public List<RouteInfoDto> getAllRoutes() {
        List<Route> routeList = routeRepository.findAll();
        List<RouteInfoDto> routesDto = new ArrayList<>();
        for (Route route : routeList) {
            RouteInfoDto routeInfoDto = modelMapper.map(route, RouteInfoDto.class);
            Picture picture = route.getPictures().stream().findFirst().get();
            routeInfoDto.setPictureUrl(picture.getUrl());
            routesDto.add(routeInfoDto);
        }
        return routesDto;
    }
}
