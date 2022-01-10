package kg.itschool.security.service;

import kg.itschool.security.model.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserDto create(UserDto userDto);
    void refreshPassword(String email);

}
