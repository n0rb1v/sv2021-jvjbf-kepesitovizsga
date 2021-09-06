package training360.guinessapp;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import training360.guinessapp.dto.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/api/worldrecords")
public class WorldrecordController {

    private final WorldrecordService worldrecordService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WorldRecordDto createWorldrecord(@Valid @RequestBody WorldRecordCreateCommand command) {
        return worldrecordService.createWorldrecord(command);
    }

    @PutMapping("/{id}/beatrecords")
    public BeatWorldRecordDto beatWorldRecord(@PathVariable("id") long id, @Valid @RequestBody BeatWorldRecordCommand command){
        return worldrecordService.beatWorldRecord(command,id);
    }
}
