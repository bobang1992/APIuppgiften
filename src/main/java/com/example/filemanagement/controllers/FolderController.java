package com.example.filemanagement.controllers;

import com.example.filemanagement.models.FolderEntity;
import com.example.filemanagement.services.FolderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/folders")
public class FolderController {
    private final FolderService folderService;

    public FolderController(FolderService folderService) {
        this.folderService = folderService;
    }

    @PostMapping("/create")
    public ResponseEntity<FolderEntity> createFolder(@RequestParam String folderName) {
        return ResponseEntity.ok(folderService.createFolder(folderName));
    }
}