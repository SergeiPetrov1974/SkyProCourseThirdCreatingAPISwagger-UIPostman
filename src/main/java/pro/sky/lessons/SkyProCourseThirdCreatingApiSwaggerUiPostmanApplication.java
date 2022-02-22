package pro.sky.lessons;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class SkyProCourseThirdCreatingApiSwaggerUiPostmanApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkyProCourseThirdCreatingApiSwaggerUiPostmanApplication.class, args);
    }
}
//http://localhost:8080/swagger-ui/index.html