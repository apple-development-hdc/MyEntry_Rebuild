package com.myentry.MyEntry.serviceImpl;

import com.myentry.MyEntry.domain.Image;
import com.myentry.MyEntry.repository.ImageRepository;
import com.myentry.MyEntry.services.ImageService;
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