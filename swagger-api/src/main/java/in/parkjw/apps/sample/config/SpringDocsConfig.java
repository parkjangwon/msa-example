package in.parkjw.apps.sample.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocsConfig {

    @Bean
    public OpenAPI openAPI(@Value("${springdoc.version}") String version) {
        Info info = new Info()
                .title("Swagger Example API Document")
                .version(version)
                .description("API의 대한 설명을 입력해주세요")
                .contact(new Contact()
                        .name("Park Jangwon")
                        .email("id@domain.com")
                        .url("https://blog.parkjw.in")
                );
        return new OpenAPI()
                .info(info);
    }
}
