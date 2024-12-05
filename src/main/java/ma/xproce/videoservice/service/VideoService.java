package ma.xproce.videoservice.service;

import ma.xproce.videoservice.dao.entities.Video;
import ma.xproce.videoservice.dto.VideoDto;
import ma.xproce.videoservice.dto.VideoDtoNew;

import java.util.List;

public interface VideoService {
    List<VideoDto> getAllVideos();
    VideoDto getVideoById(Long id);
    VideoDto addVideo(VideoDtoNew video);
    Video updateVideo(Long id, Video video);
    void deleteVideo(Long id);
}
