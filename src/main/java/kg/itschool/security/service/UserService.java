package kg.itschool.security.service;

import kg.itschool.security.model.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {
    UserDto create(UserDto userDto);
    void refreshPassword(String email);

}
