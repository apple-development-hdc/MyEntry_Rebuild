package org.myEntryApp.server.service;

import org.myEntryApp.server.domain.Image;

import java.util.Optional;

public interface ImageService {
    public Optional<Image> getImageById(Long imageId);
    public void removeImageById(Long imageId);
}
