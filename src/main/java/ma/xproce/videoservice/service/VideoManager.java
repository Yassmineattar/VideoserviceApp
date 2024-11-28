package ma.xproce.videoservice.service;
import jakarta.transaction.Transactional;
import ma.xproce.videoservice.dao.entities.Video;
import ma.xproce.videoservice.dao.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class VideoManager implements VideoService{
    @Autowired
    private VideoRepository videoRepository;
    @Override
    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }
    @Override
    public Video getVideoById(Long id) {
        return videoRepository.findById(id).orElse(null);
    }
    @Transactional
    @Override
    public Video addVideo(Video video) {
        return videoRepository.save(video);
    }
    @Override
    public Video updateVideo(Long id, Video video) {
        video.setId(id);
        return videoRepository.save(video);
    }
    @Override
    public void deleteVideo(Long id) {
        videoRepository.deleteById(id);
    }
}