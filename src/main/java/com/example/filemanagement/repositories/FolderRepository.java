package com.example.filemanagement.repositories;

import com.example.filemanagement.models.FolderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRepository extends JpaRepository<FolderEntity, Long> {
}