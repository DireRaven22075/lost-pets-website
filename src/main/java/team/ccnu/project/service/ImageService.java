package team.ccnu.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import team.ccnu.project.domain.entity.Image;
import team.ccnu.project.domain.entity.Post;
import team.ccnu.project.domain.repository.ImageRepository;

import java.util.List;

@Service
public class ImageService {
    @Autowired
    ImageRepository repository;

    public List<Image> getAll(Post post) {
        return repository.findAllByPost(post);
    }

    public Image addImage(String path) {
        Image image = new Image();
        image.setPath(path);
        return repository.save(image);
    }
    public void save(Image image) {
        repository.save(image);
    }
}
