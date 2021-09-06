package training360.guinessapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorldRecordCreateCommand {

    @NotBlank
    private String description;
    @NotNull
    private double value;
    @NotBlank
    private String unitOfMeasure;
    @NotNull
    private LocalDate dateOfRecord;
    @NotNull
    private Long Id;

}
