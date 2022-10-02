package pl.niepracuj.service.level;

import pl.niepracuj.model.dto.LevelDto;
import pl.niepracuj.model.entity.Level;

import java.util.List;

public interface LevelService {

    List<LevelDto> getAllLevels();

    LevelDto createLevel(LevelDto levelDto);
}
