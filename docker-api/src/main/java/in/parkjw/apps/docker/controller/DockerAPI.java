package in.parkjw.apps.docker.controller;

import in.parkjw.apps.docker.service.DockerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/dockerexample/v1")
public class DockerAPI {

    final DockerService docekrService;

    @GetMapping("test")
    public String test() {

        return docekrService.test();
    }
}
