package kg.itschool.security.service;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void dropPassword(String email);

}
