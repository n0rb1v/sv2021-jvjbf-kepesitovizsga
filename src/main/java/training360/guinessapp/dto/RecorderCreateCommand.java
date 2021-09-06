package training360.guinessapp.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import training360.guinessapp.IsValidTime;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecorderCreateCommand {
    @NotBlank
    private String name;
    @IsValidTime
    private LocalDate dateOfBirth;
}
