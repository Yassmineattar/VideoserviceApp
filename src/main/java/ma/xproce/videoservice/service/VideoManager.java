package ma.xproce.videoservice.service;
import ma.xproce.videoservice.dao.entities.Creator;
import ma.xproce.videoservice.dao.entities.Video;
import ma.xproce.videoservice.dao.repositories.VideoRepository;
import ma.xproce.videoservice.dto.CreatorDto;
import ma.xproce.videoservice.dto.VideoDto;
import ma.xproce.videoservice.dto.VideoDtoNew;
import ma.xproce.videoservice.mapper.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VideoManager implements VideoService {
    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    VideoMapper videoMapper;
    @Override
    public List<VideoDto> getAllVideos() {
        return videoRepository.findAll()
                .stream()
                .map(videoMapper::fromVideoToVideoDto)
                .collect(Collectors.toList());
    }
    @Override
    public VideoDto getVideoById(Long id) {
        return videoMapper.fromVideoToVideoDto(videoRepository.findById(id).get());
    }

    @Override
    public VideoDto addVideo(VideoDtoNew VideoDtoNew) {

        return videoMapper.fromVideoToVideoDto(
                videoRepository.save(
                        videoMapper.fromVideoDtoNewToVideo(VideoDtoNew)));
    }
    @Override
    public VideoDto updateVideo(Long id, VideoDto videoDto) {
        Video video = videoMapper.fromVideoDtoToVideo(videoDto);
        video.setId(id);
        Video updatedVideo = videoRepository.save(video);
        return videoMapper.fromVideoToVideoDto(updatedVideo);
    }

    @Override
    public void deleteVideo(Long id) {
        try{
        videoRepository.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException("erreur dans la suppression du video avec l'id: "+ id, e);
        }
    }

}