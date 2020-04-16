package org.myEntryApp.server.controller;

import org.myEntryApp.server.constants.UrlConstants;
import org.myEntryApp.server.domain.Image;
import org.myEntryApp.server.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = UrlConstants.VISITOR_BASE_URL)
public class ImageController {
    @Autowired
    ImageService imageService;

    @GetMapping("/image/{imageId}")
    public Image getImage(@PathVariable Long imageId) {
        Image image= imageService.getVisitorImage(imageId);
        return image;
    }
}
