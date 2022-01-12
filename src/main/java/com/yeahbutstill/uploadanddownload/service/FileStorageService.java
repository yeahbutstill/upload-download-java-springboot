package com.yeahbutstill.uploadanddownload.service;

import com.yeahbutstill.uploadanddownload.model.FileDB;
import com.yeahbutstill.uploadanddownload.repository.FileDBRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class FileStorageService {

    private FileDBRepository fileDBRepository;

    public FileDB fileDB(MultipartFile multipartFile) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        FileDB fileDB = new FileDB(fileName, multipartFile.getContentType(), fileName.getBytes());

        return fileDBRepository.save(fileDB);
    }

    public FileDB getFile(String id) {
        return fileDBRepository.findById(id).get();
    }

    public Stream<FileDB> getAllFiles() {
        return fileDBRepository.findAll().stream();
    }
}
