package az.edu.ada.wm2.courseservice.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentResponseDto {

    @Schema(description = "Qeydiyyatın unikal identifikatoru", example = "10")
    private Long enrollmentId;

    @Schema(description = "Tələbənin yazıldığı kursun id-si", example = "1")
    private Long courseId;

    @Schema(description = "Kursa yazılan tələbənin id-si", example = "15")
    private Long studentId;

    @Schema(description = "Tələbənin kursa yazıldığı tarix", example = "2026-05-20")
    private LocalDate enrollmentDate;

    @Schema(description = "Əməliyyatın nəticə mesajı", example = "Student enrolled successfully.")
    private String message;
}
