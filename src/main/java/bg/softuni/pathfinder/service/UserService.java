package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.models.dtos.UserLoginDto;
import bg.softuni.pathfinder.models.dtos.UserRegisterDto;

public interface UserService {
    void register(UserRegisterDto userRegisterDto);
    boolean loginUser(UserLoginDto userLoginDto);
    UserLoginDto mapRegisterUser(UserRegisterDto userRegisterDto);
}
