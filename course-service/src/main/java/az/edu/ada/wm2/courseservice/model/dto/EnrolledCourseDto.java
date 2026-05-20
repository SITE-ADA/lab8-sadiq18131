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
public class EnrolledCourseDto {

    @Schema(description = "Enrollment id", example = "10")
    private Long enrollmentId;

    @Schema(description = "Course id", example = "1")
    private Long courseId;

    @Schema(description = "Course title", example = "Data Structures")
    private String title;

    @Schema(description = "Course code", example = "CS201")
    private String code;

    @Schema(description = "Credit count", example = "4")
    private Integer credits;

    @Schema(description = "Optional prerequisite course id", example = "1", nullable = true)
    private Long prerequisiteCourseId;

    @Schema(description = "Date when the student was enrolled", example = "2026-05-20")
    private LocalDate enrollmentDate;
}
