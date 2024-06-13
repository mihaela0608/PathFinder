package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.models.User;
import bg.softuni.pathfinder.models.dtos.UserLoginDto;
import bg.softuni.pathfinder.models.dtos.UserRegisterDto;
import bg.softuni.pathfinder.models.enums.Level;
import bg.softuni.pathfinder.repository.UserRepository;
import bg.softuni.pathfinder.service.CurrentUser;
import bg.softuni.pathfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
    }

    @Override
    public void register(UserRegisterDto userRegisterDto) {
        User user = modelMapper.map(userRegisterDto, User.class);
        user.setLevel(Level.valueOf(userRegisterDto.getLevel()));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.saveAndFlush(user);
    }

    @Override
    public boolean loginUser(UserLoginDto userLoginDto) {
        Optional<User> optionalUser = userRepository.findByUsername(userLoginDto.getUsername());
        if (optionalUser.isEmpty()){
            return false;
        }
        User user = optionalUser.get();
        if (passwordEncoder.matches(userLoginDto.getPassword(), user.getPassword())){
            currentUser.setUser(user);
            return true;
        }
        return false;
    }

    @Override
    public UserLoginDto mapRegisterUser(UserRegisterDto userRegisterDto) {
        return modelMapper.map(userRegisterDto, UserLoginDto.class);
    }
}
