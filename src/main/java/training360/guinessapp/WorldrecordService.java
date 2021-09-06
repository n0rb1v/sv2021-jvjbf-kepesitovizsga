package training360.guinessapp;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import training360.guinessapp.dto.*;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class WorldrecordService {

    private final WorldrecordRepository worldrecordRepository;
    private final RecorderRepository recorderRepository;
    private final ModelMapper modelMapper;

    public WorldRecordDto createWorldrecord(WorldRecordCreateCommand command) {
        Worldrecord worldrecord = new Worldrecord(
                command.getDescription(),
                command.getValue(),
                command.getUnitOfMeasure(),
                command.getDateOfRecord(),
                command.getId());
        Recorder recorder = recorderRepository.findById(command.getId()).orElseThrow(() -> new RecorderNotFoundException());
        worldrecordRepository.save(worldrecord);
        WorldRecordDto wrDTO = modelMapper.map(worldrecord, WorldRecordDto.class);
        wrDTO.setRecorderName(recorder.getName());
        return wrDTO;
    }

    @Transactional
    public BeatWorldRecordDto beatWorldRecord(BeatWorldRecordCommand command, long id) {
        Worldrecord worldrecord = worldrecordRepository.findById(command.getId()).orElseThrow(() -> new WorldrecordNotFoundException());
        Recorder recorderNew = recorderRepository.findById(id).orElseThrow(() -> new RecorderNotFoundException());
        Recorder recorderOld = recorderRepository.findById(worldrecord.getRecorderId()).orElseThrow(() -> new RecorderNotFoundException());
        BeatWorldRecordDto bwrDTO = null;
        if (worldrecord.getValue() < command.getNewRecord()) {
            bwrDTO = new BeatWorldRecordDto(
                    worldrecord.getDescription(),
                    worldrecord.getUnitOfMeasure(),
                    recorderOld.getName(),
                    recorderNew.getName(),
                    command.getNewRecord(),
                    command.getNewRecord()- worldrecord.getValue());

            worldrecord.setRecorderId(recorderNew.getId());
        }else{
            throw new NotBeatException();
        }

        worldrecordRepository.save(worldrecord);

        return bwrDTO;
    }
}
