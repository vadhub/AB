package com.backend.athletica.service;

import com.backend.athletica.entity.FileRequest;
import com.backend.athletica.entity.Image;
import com.backend.athletica.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

@Service
public class FileStorageService implements FileStorage {

    private final Path root = Paths.get("uploads");
    private final ImageRepository imageRepository;

    @Autowired
    public FileStorageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public void init() {
        try {
            Files.createDirectories(root);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    @Override
    public Image saveImage(FileRequest imageRequest) {
        try {
            if (imageRequest.getFile().isEmpty()) throw new IllegalArgumentException("empty file");
            String img = DigestUtils.md5DigestAsHex((imageRequest.getFile().getOriginalFilename()+" "+System.currentTimeMillis()).getBytes());
            Files.copy(imageRequest.getFile().getInputStream(), root.resolve(img));
            Image temp = new Image(img, imageRequest.getDateCreated(), imageRequest.getDateChanged());
            return imageRepository.save(temp);
        } catch (Exception e) {
            if (e instanceof FileAlreadyExistsException) {
                throw new RuntimeException("A file of that name already exists.");
            }
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Resource load(String directory) {
        try {
            Path file = Paths.get(directory);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public Resource loadImageById(Long id) {
        try {
            String uri = imageRepository.findById(id).orElseThrow(() -> new NoSuchElementException("non exist " + id)).getImageUri();
            Path file = Paths.get("uploads/"+uri);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public Image getImageById(Long id) {
        return imageRepository.findById(id).orElse(new Image());
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Could not load the files!");
        }
    }

}
