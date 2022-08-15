package in.parkjw.apps.sample.controller;

import in.parkjw.apps.core.annotation.ApiDocumentResponse;
import in.parkjw.apps.sample.service.SwaggerExampleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "sample", description = "Swagger3 적용 예제입니다.")
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/swaggerexample/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class SwaggerExampleAPI {

    final SwaggerExampleService sampleService;

    @Operation(summary = "Swagger Example API", description = "Swagger 적용 예제 API")
    @ApiDocumentResponse
    @GetMapping("test")
    public String test() {

        return sampleService.test();
    }
}
