package ma.xproce.videoservice.web;
import ma.xproce.videoservice.dto.VideoDto;
import ma.xproce.videoservice.dto.VideoDtoNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import ma.xproce.videoservice.dao.entities.Video;
import ma.xproce.videoservice.service.VideoManager;

import java.util.List;
@Controller
public class VideoController {
    @Autowired
    private VideoManager videoManager;
    @GetMapping("/getVideosList")
    public String getAllVideos(Model model) {
        List<VideoDto> videos = videoManager.getAllVideos();
        model.addAttribute("listVideos", videos);
        return "listVideos";
    }
    @GetMapping("/addVideo")
    public String addVideoForm(Model model) {
        return "addVideo";
    }
    @PostMapping("/addVideo")
    public String addVideoToDb(Model model,
                               @RequestParam(name = "name") String name,
                               @RequestParam(name = "url") String url,
                               @RequestParam(name = "description") String description) {
        VideoDtoNew newVideo = new VideoDtoNew();
        newVideo.setName(name);
        newVideo.setUrl(url);
        newVideo.setDescription(description);
        videoManager.addVideo(newVideo);
        return getAllVideos(model);
    }
    @GetMapping("/editVideo/{id}")
    public String editVideoForm(Model model, @PathVariable Long id) {
        VideoDto video = videoManager.getVideoById(id);
        model.addAttribute("video", video);
        return "editVideo";  // Vue de formulaire pour la modification
    }
    @PostMapping("/updateVideo")
    public String updateVideo(Model model,
                              @RequestParam(name = "id") Long id,
                              @RequestParam(name = "name") String name,
                              @RequestParam(name = "url") String url,
                              @RequestParam(name = "description") String description) {
        VideoDto updatedVideo = new VideoDto();
        updatedVideo.setName(name);
        updatedVideo.setUrl(url);
        updatedVideo.setDescription(description);
        videoManager.updateVideo(id, updatedVideo);
        return getAllVideos(model);
    }
    @GetMapping("/deleteVideo/{id}")
    public String deleteVideo(Model model, @PathVariable Long id) {
        videoManager.deleteVideo(id);
        return getAllVideos(model);
    }
}
