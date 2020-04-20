package com.myentry.MyEntry.services;

import com.myentry.MyEntry.domain.Image;

import java.util.Optional;

public interface ImageService {
    public Optional<Image> getImageById(Long imageId);
    public void removeImageById(Long imageId);
}
