package kg.itschool.security.service.impl;

import kg.itschool.security.util.GenerateSecurePassword;
import kg.itschool.security.mapper.UserMapper;
import kg.itschool.security.model.dto.UserDto;
import kg.itschool.security.model.entity.User;
import kg.itschool.security.repository.UserRepository;
import kg.itschool.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto create(UserDto userDto) {

        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new RuntimeException("Email: " + userDto.getEmail() + " already in use");
        }

        if (userDto.getUsername() == null || userDto.getUsername().trim().equals("")) {
            userDto.setUsername(userDto.getEmail().substring(0, userDto.getEmail().indexOf('@')));
        }

        if (userRepository.existsByUsername(userDto.getUsername())) {
            throw new RuntimeException("Username: " + userDto.getUsername() + " already in use");
        }


        User user = User.builder()
                .firstName(userDto.getFirstName())
                .email(userDto.getEmail())
                .lastName(userDto.getLastName())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .username(userDto.getUsername())
                .build();

        userRepository.save(user);

        return UserMapper.INSTANCE.toDto(user);
    }

    @Override
    public void refreshPassword(String email) {
        userRepository.findByEmail(email).map(user -> {
            String newPassword = GenerateSecurePassword.generatePassword(10);
            // send to email newPassword
            user.setPassword(passwordEncoder.encode(newPassword));
            return userRepository.save(user);
        });
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("sd"));
    }
}
