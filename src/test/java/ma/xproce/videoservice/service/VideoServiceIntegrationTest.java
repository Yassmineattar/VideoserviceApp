package ma.xproce.videoservice.service;
import ma.xproce.videoservice.dao.entities.Creator;
import ma.xproce.videoservice.dao.entities.Video;
import ma.xproce.videoservice.dao.repositories.CreatorRepository;
import ma.xproce.videoservice.dao.repositories.VideoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ActiveProfiles("test")
public class VideoServiceIntegrationTest {
    @Autowired
    private VideoService videoService;
    @Autowired
    private CreatorRepository creatorRepository;
    @Autowired
    private VideoRepository videoRepository;
    @BeforeEach
    public void setUp() {
        videoRepository.deleteAll();
        creatorRepository.deleteAll();
    }
    @Test
    public void testAddAndRetrieveVideo() {
        Creator creator = new Creator();
        creator.setName("Test Creator");
        creator.setEmail("creator@example.com");
        creator = creatorRepository.save(creator);
        Video video = new Video(null, "Test Video", "http://example.com", "Test Description", creator);
        videoService.addVideo(video);
        List<Video> videos = videoService.getAllVideos();
        assertEquals(1, videos.size());
        assertEquals("Test Video", videos.get(0).getName());
        assertEquals("Test Creator", videos.get(0).getCreator().getName());
    }

    @Test
    public void testDeleteVideo() {
        Creator creator = new Creator();
        creator.setName("Delete Creator");
        creator.setEmail("delete@example.com");
        creator = creatorRepository.save(creator);
        Video video = new Video(null, "Delete Video", "http://example.com/delete", "To be deleted", creator);
        video = videoService.addVideo(video);
        videoService.deleteVideo(video.getId());
        assertNull(videoService.getVideoById(video.getId()));
    }

    @Test
    public void testUpdateVideo() {
        Creator creator = new Creator();
        creator.setName("Original Creator");
        creator.setEmail("original@example.com");
        creator = creatorRepository.save(creator);
        Video video = new Video(null, "Old Video", "http://example.com/old", "Old Description", creator);
        video = videoService.addVideo(video);
        video.setName("Updated Video");
        videoService.updateVideo(video.getId(), video);
        Video updatedVideo = videoService.getVideoById(video.getId());
        assertEquals("Updated Video", updatedVideo.getName());
        assertEquals("Original Creator", updatedVideo.getCreator().getName());
    }
}