package com.example.filemanagement.services;

import com.example.filemanagement.models.FolderEntity;
import com.example.filemanagement.repositories.FolderRepository;
import org.springframework.stereotype.Service;

@Service
public class FolderService {
    private final FolderRepository folderRepository;

    public FolderService(FolderRepository folderRepository) {
        this.folderRepository = folderRepository;
    }

    public FolderEntity createFolder(String folderName) {
        FolderEntity folder = new FolderEntity();
        folder.setFolderName(folderName);
        return folderRepository.save(folder);
    }
}