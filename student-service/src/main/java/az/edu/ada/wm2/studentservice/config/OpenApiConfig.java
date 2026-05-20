package az.edu.ada.wm2.studentservice.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Student Service API",
                version = "v1",
                description = "Tələbə məlumatlarının yaradılması, oxunması, yenilənməsi, silinməsi və ada görə axtarışı üçün API.",
                contact = @Contact(name = "WM2 Backend kursu"),
                license = @License(name = "Tədris məqsədli istifadə")
        ),
        servers = {
                @Server(url = "http://localhost:9090", description = "Lokal student-service serveri")
        }
)
public class OpenApiConfig {
}
