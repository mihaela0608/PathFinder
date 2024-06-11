package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.models.dtos.UserRegisterDto;

public interface UserService {
    void register(UserRegisterDto userRegisterDto);
}
