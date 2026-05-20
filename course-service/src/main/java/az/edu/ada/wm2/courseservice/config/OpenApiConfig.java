package az.edu.ada.wm2.courseservice.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Course Service API",
                version = "v1",
                description = "Kursların idarə edilməsi, tələbə qeydiyyatı, prerequisite yoxlaması və tələbəyə görə kurs axtarışı üçün API.",
                contact = @Contact(name = "WM2 Backend kursu"),
                license = @License(name = "Tədris məqsədli istifadə")
        ),
        servers = {
                @Server(url = "http://localhost:8081", description = "Lokal course-service serveri")
        }
)
public class OpenApiConfig {
}
