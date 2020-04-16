package org.myEntryApp.server.controller;

import org.myEntryApp.server.constants.UrlConstants;
import org.myEntryApp.server.domain.Image;
import org.myEntryApp.server.serviceImpl.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = UrlConstants.VISITOR_BASE_URL)
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
