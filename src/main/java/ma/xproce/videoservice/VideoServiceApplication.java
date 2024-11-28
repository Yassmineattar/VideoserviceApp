package ma.xproce.videoservice;

import ma.xproce.videoservice.dao.entities.Creator;
import ma.xproce.videoservice.dao.entities.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ma.xproce.videoservice.dao.repositories.VideoRepository;
import ma.xproce.videoservice.dao.repositories.CreatorRepository;
@SpringBootApplication
public class VideoServiceApplication {
    @Autowired
    private CreatorRepository creatorRepository;
    @Autowired
    private VideoRepository videoRepository;

    public static void main(String[] args) {
        SpringApplication.run(VideoServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start() {
        return args -> {
            Creator creator1 = new Creator();
            creator1.setName("Yassmine Attar");
            creator1.setEmail("yassmine@gmail.com");

            Creator creator2 = new Creator();
            creator2.setName("jiji ameziane");
            creator2.setEmail("jiji123@gmail.com");

            creatorRepository.save(creator1);
            creatorRepository.save(creator2);

            // Création et sauvegarde de quelques Videos
            Video video1 = new Video();
            video1.setName("Spring Boot Tutorial");
            video1.setUrl("http://example.com/spring-boot-tutorial");
            video1.setDescription("Introduction to Spring Boot");
            video1.setCreator(creator1);

            Video video2 = new Video();
            video2.setName("JPA Basics");
            video2.setUrl("http://example.com/jpa-basics");
            video2.setDescription("Learn the basics of JPA");
            video2.setCreator(creator2);

            Video video3 = new Video();
            video3.setName("Spring Boot Jpa");
            video3.setUrl("http://example.com/spring-boot-Jpa");
            video3.setDescription("Introduction to Spring Jpa");
            video3.setCreator(creator1);

            videoRepository.save(video1);
            videoRepository.save(video2);
            videoRepository.save(video3);

        };
    }

}
