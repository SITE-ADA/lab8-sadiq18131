package az.edu.ada.wm2.courseservice.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiErrorResponse {

    @Schema(description = "Xətanın baş verdiyi vaxt", example = "2026-05-20T23:30:00")
    private LocalDateTime timestamp;

    @Schema(description = "HTTP status kodu", example = "400")
    private int status;

    @Schema(description = "HTTP xəta adı", example = "Bad Request")
    private String error;

    @Schema(description = "Xətanın oxunaqlı izahı", example = "Prerequisite course not found with id: 99")
    private String message;

    @Schema(description = "Xətanın baş verdiyi endpoint yolu", example = "/api/v1/courses/2/students/15")
    private String path;
}
