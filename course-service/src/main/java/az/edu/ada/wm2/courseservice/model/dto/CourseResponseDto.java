package az.edu.ada.wm2.courseservice.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponseDto {

    @Schema(description = "Kursun unikal identifikatoru", example = "1")
    private Long id;

    @Schema(description = "Kursun adı", example = "Data Structures")
    private String title;

    @Schema(description = "Kursun unikal kodu", example = "CS201")
    private String code;

    @Schema(description = "Kursun kredit sayı", example = "4")
    private Integer credits;

    @Schema(description = "Optional prerequisite kursunun id-si. Prerequisite yoxdursa null qaytarılır.", example = "1", nullable = true)
    private Long prerequisiteCourseId;
}
