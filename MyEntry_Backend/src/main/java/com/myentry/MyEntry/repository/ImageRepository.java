package com.myentry.MyEntry.repository;

import com.myentry.MyEntry.domain.Image;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<Image, Long> {
}
