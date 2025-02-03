package com.example.filemanagement.services;

import com.example.filemanagement.models.FolderEntity;
import com.example.filemanagement.repositories.FolderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FolderService {
    private final FolderRepository folderRepository;

    public FolderService(FolderRepository folderRepository) {
        this.folderRepository = folderRepository;
    }

    public FolderEntity createFolder(String folderName, Long parentFolderId) {
        FolderEntity folder = new FolderEntity();
        folder.setFolderName(folderName);

        if (parentFolderId != null) {
            Optional<FolderEntity> parentFolder = folderRepository.findById(parentFolderId);
            parentFolder.ifPresent(folder::setParentFolder);
        }

        return folderRepository.save(folder);
    }
}