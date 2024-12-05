package ma.xproce.videoservice.service;
import ma.xproce.videoservice.dao.entities.Creator;
import ma.xproce.videoservice.dao.repositories.CreatorRepository;
import ma.xproce.videoservice.dto.CreatorDto;
import ma.xproce.videoservice.dto.CreatorDtoNew;
import ma.xproce.videoservice.mapper.CreatorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreatorManager implements CreatorService {
    @Autowired
    private CreatorRepository creatorRepository;
    @Autowired
    CreatorMapper creatorMapper;
    @Override
    public List<CreatorDto> getAllCreators() {
        return creatorRepository.findAll()
                .stream()
                .map(creatorMapper::fromCreatorToCreatorDto)
                .collect(Collectors.toList());
    }
    @Override
    public CreatorDto getCreatorById(Long id) {
        return creatorMapper.fromCreatorToCreatorDto(creatorRepository.findById(id).get());
    }

    @Override
    public CreatorDto addCreator(CreatorDtoNew CreatorDtoNew) {

        return creatorMapper.fromCreatorToCreatorDto(
                creatorRepository.save(
                        creatorMapper.fromCreatorDtoNewToCreator(CreatorDtoNew)));
    }
    @Override
    public Creator updateCreator(Long id, Creator creator) {
        creator.setId(id);
        return creatorRepository.save(creator);
    }

    @Override
    public void deleteCreator(Long id) {
        creatorRepository.deleteById(id);
    }

}