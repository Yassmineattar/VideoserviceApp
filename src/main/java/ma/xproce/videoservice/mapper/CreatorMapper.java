package ma.xproce.videoservice.mapper;


import ma.xproce.videoservice.dao.entities.Creator;
import ma.xproce.videoservice.dto.CreatorDto;
import ma.xproce.videoservice.dto.CreatorDtoNew;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CreatorMapper {
    ModelMapper mapper = new ModelMapper();
    public CreatorDto fromCreatorToCreatorDto(Creator creator){
        return mapper.map(creator, CreatorDto.class);
    }

    public Creator fromCreatorDtoToCreator(CreatorDto creatorDto){
        return mapper.map(creatorDto, Creator.class);
    }

    public Creator fromCreatorDtoNewToCreator(CreatorDtoNew creatorDtoNew){
        return mapper.map(creatorDtoNew, Creator.class);
    }

}
