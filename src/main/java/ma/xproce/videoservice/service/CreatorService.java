package ma.xproce.videoservice.service;

import ma.xproce.videoservice.dao.entities.Creator;
import java.util.List;

public interface CreatorService {
    List<Creator> getAllCreators();
    Creator getCreatorById(Long id);
    Creator addCreator(Creator creator);
    Creator updateCreator(Long id, Creator creator);
    void deleteCreator(Long id);

}
