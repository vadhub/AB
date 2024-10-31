package com.backend.athletica.service;

import com.backend.athletica.entity.FileRequest;
import com.backend.athletica.entity.Image;
import org.springframework.core.io.Resource;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface FileStorage {

    void init();

    Image saveImage(FileRequest imageRequest);

    Resource load(String directory);

    Resource loadImageById(Long id);

    Image getImageById(Long id);

    Stream<Path> loadAll();
}