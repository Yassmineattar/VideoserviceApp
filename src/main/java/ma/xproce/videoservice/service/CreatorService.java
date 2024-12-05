package ma.xproce.videoservice.service;

import ma.xproce.videoservice.dao.entities.Creator;
import ma.xproce.videoservice.dto.CreatorDto;
import ma.xproce.videoservice.dto.CreatorDtoNew;

import java.util.List;

public interface CreatorService {
    List<CreatorDto> getAllCreators();
    CreatorDto getCreatorById(Long id);
    CreatorDto addCreator(CreatorDtoNew creatorDtoNew);
    CreatorDto updateCreator(Long id, CreatorDto creatorDto);
    void deleteCreator(Long id);
}
