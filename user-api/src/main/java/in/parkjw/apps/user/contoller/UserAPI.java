package in.parkjw.apps.user.contoller;

import in.parkjw.apps.user.dto.UserDTO;
import in.parkjw.apps.user.entity.User;
import in.parkjw.apps.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user/v1")
public class UserAPI {

    final UserService userService;

    @GetMapping("test")
    public String test() {

        return userService.test();
    }

    @GetMapping(value = "/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> find(@PathVariable("id") @NotNull Long id) {
        User result = userService.find(id);

        return new ResponseEntity<>( result, HttpStatus.OK );
    }

    @GetMapping(value = "/findall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDTO.View>> findAll() {
        List<UserDTO.View> result = userService.findAll();

        return new ResponseEntity<>( result, HttpStatus.OK );
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO.View> add(@RequestBody UserDTO.Create dto) {

        User user = dto.convert(User.class);
        User saveUser = userService.add(user);
        UserDTO.View view = saveUser.convert(UserDTO.View.class);

        return new ResponseEntity<>(view, HttpStatus.CREATED);
    }
}
