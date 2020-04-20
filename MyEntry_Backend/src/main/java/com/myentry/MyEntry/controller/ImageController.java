package com.myentry.MyEntry.controller;


import com.myentry.MyEntry.constants.APIConstants;
import com.myentry.MyEntry.domain.Image;
import com.myentry.MyEntry.serviceImpl.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = APIConstants.VISITOR_BASE_URL)
public class ImageController {

    @Autowired
    ImageServiceImpl imageServiceImpl;
    @GetMapping("/image/{imageId}")
    public Optional<Image> getImage(@PathVariable Long imageId) {
        Optional<Image> image= imageServiceImpl.getImageById(imageId);
        return image;
    }

    @DeleteMapping("/image/{imageId}")
    public void removeImage(@PathVariable Long imageId) {
        imageServiceImpl.removeImageById(imageId);
    }

}
