package com.backend.athletica.controller;


import com.backend.athletica.entity.FileRequest;
import com.backend.athletica.entity.Icon;
import com.backend.athletica.entity.Image;
import com.backend.athletica.entity.ResponseMessage;
import com.backend.athletica.repository.IconRepository;
import com.backend.athletica.service.FileStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api-v1")
public class FilesController {

    private final FileStorage fileStorage;
    private final IconRepository iconRepository;

    @Autowired
    public FilesController(FileStorage fileStorage, IconRepository iconRepository) {
        this.fileStorage = fileStorage;
        this.iconRepository = iconRepository;
    }

    @PostMapping("/upload/image")
    public ResponseEntity<Object> uploadImage(@ModelAttribute FileRequest imageRequest) {
        String messageResponse = "";
        try {
            return ResponseEntity.status(HttpStatus.OK).body(fileStorage.saveImage(imageRequest));
        } catch (Exception e) {
            messageResponse = "Could not upload the file: " + imageRequest.getFile().getOriginalFilename() + ". Error: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(messageResponse));
        }
    }

    @PostMapping("/upload/icon")
    public ResponseEntity<Object> uploadIcon(@ModelAttribute FileRequest imageRequest, @RequestParam Long userId) {
        String messageResponse = "";
        try {

            Optional<Icon> iconOptional = iconRepository.getIconByUserId(userId);
            Image image = fileStorage.saveImage(imageRequest);

            if (iconOptional.isPresent()) {
                Icon icon = iconOptional.get();
                icon.setImage(image);
                iconRepository.save(icon);
            } else {
                iconRepository.save(new Icon(image, userId));
            }


            return ResponseEntity.status(HttpStatus.OK).body(image);
        } catch (Exception e) {
            messageResponse = "Could not upload the file: " + imageRequest.getFile().getOriginalFilename() + ". Error: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(messageResponse));
        }
    }

    @GetMapping("/files/icon/search")
    @ResponseBody
    public ResponseEntity<Object> getIcon(@RequestParam Long userId) {
        Image image = iconRepository.getIconByUserId(userId).orElse(new Icon()).getImage();
        if (image == null) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("not found"));
        }
        Resource file = fileStorage.load("uploads/"+image.getImageUri());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @GetMapping("/files/image/search")
    @ResponseBody
    public ResponseEntity<Resource> getImage(@RequestParam Long id) {
        Resource file = fileStorage.loadImageById(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}