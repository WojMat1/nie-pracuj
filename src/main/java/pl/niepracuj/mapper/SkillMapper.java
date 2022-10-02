package pl.niepracuj.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.niepracuj.model.dto.SkillDto;
import pl.niepracuj.model.dto.StateDto;
import pl.niepracuj.model.entity.Skill;
import pl.niepracuj.model.entity.State;

@Component
@RequiredArgsConstructor
public class SkillMapper {

    private final LevelMapper levelMapper;

    public SkillDto toDto(Skill skill) {
        return SkillDto.builder()
                .id(skill.getId())
                .name(skill.getName())
                .level(levelMapper.toDto(skill.getLevel()))
                .build();
    }
}