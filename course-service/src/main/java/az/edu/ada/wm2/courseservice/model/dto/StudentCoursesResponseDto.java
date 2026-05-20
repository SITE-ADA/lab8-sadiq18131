package az.edu.ada.wm2.courseservice.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentCoursesResponseDto {

    @Schema(description = "Ad axtarışına uyğun gələn tələbə")
    private StudentDto student;

    @Schema(description = "Tapılan tələbənin yazıldığı kurslar")
    private List<EnrolledCourseDto> courses;
}
