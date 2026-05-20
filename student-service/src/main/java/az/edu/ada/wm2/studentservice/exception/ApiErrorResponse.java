package az.edu.ada.wm2.studentservice.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiErrorResponse {

    @Schema(description = "Xətanın baş verdiyi vaxt", example = "2026-05-20T23:30:00")
    private LocalDateTime timestamp;

    @Schema(description = "HTTP status kodu", example = "404")
    private int status;

    @Schema(description = "HTTP xəta adı", example = "Not Found")
    private String error;

    @Schema(description = "Xətanın oxunaqlı izahı", example = "Student not found with id: 15")
    private String message;

    @Schema(description = "Xətanın baş verdiyi endpoint yolu", example = "/api/v1/students/15")
    private String path;
}
