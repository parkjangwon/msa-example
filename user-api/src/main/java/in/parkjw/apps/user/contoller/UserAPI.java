package in.parkjw.apps.user.contoller;

import in.parkjw.apps.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user/v1")
public class UserAPI {

    final UserService userService;

    @GetMapping("test")
    public String test() {

        return userService.test();
    }
}
