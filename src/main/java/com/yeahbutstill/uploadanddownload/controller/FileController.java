package com.yeahbutstill.uploadanddownload.controller;

import com.yeahbutstill.uploadanddownload.message.ResponseMessage;
import com.yeahbutstill.uploadanddownload.service.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Controller
@CrossOrigin("http://localhost:8080")
public class FileController {

    private FileStorageService fileStorageService;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file")MultipartFile multipartFile) {
        String message = "";
        try {
            fileStorageService.fileDB(multipartFile);
            message = "Upload the file successfuly: " + multipartFile.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + multipartFile.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

}
