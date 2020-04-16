package org.myEntryApp.server.repository;


import org.myEntryApp.server.domain.Image;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<Image, Long> {

}
