package in.parkjw.apps.user.service;

import in.parkjw.apps.core.mapper.MapperUtils;
import in.parkjw.apps.user.dto.UserDTO;
import in.parkjw.apps.user.entity.User;
import in.parkjw.apps.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    final UserRepository userRepository;

    public String test() {

        return "Hello, User's API Test!";
    }

    public User find(Long id) {

        return userRepository.findUserById(id);
    }

    public List<UserDTO.View> findAll() {
        List<User> source = userRepository.findAll();

        return MapperUtils.mapList(source, UserDTO.View.class);
    }

    public User add(User user) {
        User result = userRepository.save(user);

        return result;
    }
}
