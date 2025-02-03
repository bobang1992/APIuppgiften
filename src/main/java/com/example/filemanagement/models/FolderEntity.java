package com.example.filemanagement.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "folders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FolderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String folderName;

    @OneToMany(mappedBy = "folder", cascade = CascadeType.ALL)
    private List<FileEntity> files;

    // Lägg till stöd för undermappar
    @ManyToOne
    @JoinColumn(name = "parent_folder_id")
    private FolderEntity parentFolder;

    @OneToMany(mappedBy = "parentFolder", cascade = CascadeType.ALL)
    private List<FolderEntity> subFolders;
}