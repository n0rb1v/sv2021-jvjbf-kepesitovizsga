package training360.guinessapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeatWorldRecordCommand {

    @NotNull
    private Long id;
    @NotNull
    private Double newRecord;
}
