package training360.guinessapp;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import training360.guinessapp.dto.RecorderCreateCommand;
import training360.guinessapp.dto.RecorderDto;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/recorders")
public class RecorderController {

    private final RecorderService recorderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    //@Operation(summary = "creates a player")
    @ApiResponse(responseCode = "201",description = "recorder created")
    public RecorderDto createRecorder(@Valid @RequestBody RecorderCreateCommand command) {
        return recorderService.createRecorder(command);
    }

    @GetMapping
    //@Operation(summary = "list of persons")
    public List<RecorderDto> listSpec() {
        return recorderService.listSpec();
    }
}
