package ma.xproce.videoservice.service;

import ma.xproce.videoservice.dao.entities.Video;
import java.util.List;

public interface VideoService {
    List<Video> getAllVideos();
    Video getVideoById(Long id);
    Video addVideo(Video video);
    Video updateVideo(Long id, Video video);
    void deleteVideo(Long id);
}
