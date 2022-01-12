package com.yeahbutstill.uploadanddownload.repository;

import com.yeahbutstill.uploadanddownload.model.FileDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {
}
