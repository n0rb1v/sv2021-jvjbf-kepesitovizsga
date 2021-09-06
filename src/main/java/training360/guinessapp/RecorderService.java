package training360.guinessapp;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import training360.guinessapp.dto.RecorderCreateCommand;
import training360.guinessapp.dto.RecorderDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RecorderService {

    private final RecorderRepository recorderRepository;
    private final ModelMapper modelMapper;


    public RecorderDto createRecorder(RecorderCreateCommand command) {
        Recorder recorder = new Recorder(
                command.getName(),
                command.getDateOfBirth());
        recorderRepository.save(recorder);
        return modelMapper.map(recorder,RecorderDto.class);
    }

    public List<RecorderDto> listSpec() {
        return recorderRepository.listSpec().stream()
                .map(r -> modelMapper.map(r,RecorderDto.class))
                .collect(Collectors.toList());
    }
}
