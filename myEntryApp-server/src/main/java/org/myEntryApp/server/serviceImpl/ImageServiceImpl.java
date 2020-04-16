package org.myEntryApp.server.serviceImpl;

import org.myEntryApp.server.domain.Image;
import org.myEntryApp.server.repository.ImageRepository;
import org.myEntryApp.server.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageRepository imageRepository;

    @Override
    public Optional<Image> getImageById(Long imageId) {
        Optional<Image> image= imageRepository.findById(imageId);
        return image;
    }

    @Override
    public void removeImageById(Long imageId) {
        try {
            imageRepository.deleteById(imageId);
        }
        catch(EmptyResultDataAccessException e){
            e.printStackTrace();
        }

    }
}
