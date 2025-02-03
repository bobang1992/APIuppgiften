package com.example.filemanagement.services;

import com.example.filemanagement.models.FileEntity;
import com.example.filemanagement.models.FolderEntity;
import com.example.filemanagement.repositories.FileRepository;
import com.example.filemanagement.repositories.FolderRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService {
    private final FileRepository fileRepository;
    private final FolderRepository folderRepository;

    public FileService(FileRepository fileRepository, FolderRepository folderRepository) {
        this.fileRepository = fileRepository;
        this.folderRepository = folderRepository;
    }

    public FileEntity uploadFile(Long folderId, MultipartFile file) throws IOException {
        // Hämta mappen
        FolderEntity folder = folderRepository.findById(folderId)
                .orElseThrow(() -> new RuntimeException("Folder not found"));

        // Sparar filen till lagringen
        // Ange din lagringsväg här
        String fileStorageLocation = "path/to/your/storage";
        Path filePath = Paths.get(fileStorageLocation, file.getOriginalFilename());
        Files.copy(file.getInputStream(), filePath);

        // Skapa en FileEntity och spara den i databasen
        FileEntity fileEntity = new FileEntity();
        fileEntity.setFileName(file.getOriginalFilename());
        fileEntity.setFilePath(filePath.toString());
        fileEntity.setFolder(folder);

        return fileRepository.save(fileEntity);
    }

    public void deleteFile(Long fileId) {
        fileRepository.deleteById(fileId);
    }

    public FileEntity getFileById(Long fileId) {
        return fileRepository.findById(fileId)
                .orElseThrow(() -> new RuntimeException("File not found"));
    }
}