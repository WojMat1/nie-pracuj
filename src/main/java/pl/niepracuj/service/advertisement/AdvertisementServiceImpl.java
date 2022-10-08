package pl.niepracuj.service.advertisement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.niepracuj.exception.exceptions.EntityNotFoundException;
import pl.niepracuj.exception.exceptions.ResourceNotFoundException;
import pl.niepracuj.exception.messages.ExceptionMessages;
import pl.niepracuj.model.entity.*;
import pl.niepracuj.model.mapper.AdvertisementMapper;
import pl.niepracuj.model.mapper.SkillMapper;
import pl.niepracuj.model.dto.AdvertisementCreateDto;
import pl.niepracuj.model.dto.AdvertisementDto;
import pl.niepracuj.repository.*;

import javax.transaction.Transactional;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class AdvertisementServiceImpl implements AdvertisementService {

    private final AdvertisementRepository advertisementRepository;

    private final AdvertisementMapper advertisementMapper;

    private final CompanyRepository companyRepository;

    private final TechnologyRepository technologyRepository;

    private final SeniorityRepository seniorityRepository;

    private final CityRepository cityRepository;

    private final LevelRepository levelRepository;

    private final SkillMapper skillMapper;

    private final SkillRepository skillRepository;


    @Override
    public List<AdvertisementDto> getAllAdvertisements() {
        return advertisementRepository.findAll().stream().map(advertisementMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AdvertisementDto createAdvertisement(AdvertisementCreateDto createDto) {

        Advertisement advertisement = advertisementMapper.toNewEntity(createDto);
        advertisement.setPublishDate(LocalDateTime.now());


        advertisement.setCompany(companyRepository.findById(createDto.getCompanyId())
                .orElseThrow(() -> new EntityNotFoundException(Company.class.getSimpleName(),createDto.getCompanyId())));

        advertisement.setTechnology(technologyRepository.findById(createDto.getTechnologyId())
                .orElseThrow(() -> new EntityNotFoundException(Technology.class.getSimpleName(),createDto.getTechnologyId())));

        advertisement.setSeniority(seniorityRepository.findById(createDto.getSeniorityId())
                .orElseThrow(() -> new EntityNotFoundException(Seniority.class.getSimpleName(),createDto.getSeniorityId())));

        advertisement.setCity(cityRepository.findById(createDto.getCityId())
                .orElseThrow(() -> new EntityNotFoundException(City.class.getSimpleName(),createDto.getCityId())));

        List<Skill> skills = createDto.getSkills().stream()
                .map(skillCreateDto -> {
                    Skill skill = skillMapper.toNewEntity(skillCreateDto);
                    skill.setLevel(levelRepository.findById(skillCreateDto.getLevelId()).orElseThrow(RuntimeException::new));
                    return skill;
                }).collect(Collectors.toList());

        advertisement.setSkills(new HashSet<>(skillRepository.saveAllAndFlush(skills)));
        return advertisementMapper.toDto(advertisementRepository.save(advertisement));
    }
}
