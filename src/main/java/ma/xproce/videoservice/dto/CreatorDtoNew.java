package ma.xproce.videoservice.dto;
import jakarta.persistence.OneToMany;
import lombok.*;
import ma.xproce.videoservice.dao.entities.Video;

import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class CreatorDtoNew {
    private String name;
    private String email;
    private Collection<Video> video;
}
