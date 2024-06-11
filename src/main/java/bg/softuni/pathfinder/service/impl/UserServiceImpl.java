package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.models.User;
import bg.softuni.pathfinder.models.dtos.UserRegisterDto;
import bg.softuni.pathfinder.models.enums.Level;
import bg.softuni.pathfinder.repository.UserRepository;
import bg.softuni.pathfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void register(UserRegisterDto userRegisterDto) {
        User user = modelMapper.map(userRegisterDto, User.class);
        user.setLevel(Level.BEGINNER);
        userRepository.saveAndFlush(user);
    }
}
