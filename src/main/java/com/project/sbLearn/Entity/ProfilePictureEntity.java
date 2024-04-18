package com.project.sbLearn.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "profile_picture")
public class ProfilePictureEntity {
    @Id
    @Column(name = "PP_ID", length = 36)
    private String pp_id;

    @Column(name = "NAME", length = 50)
    private String imgName;

//    @Lob
//    @Column(name = "IMAGE_FILE")
//    private String imageFile;

    @Lob
    @Column(name = "IMAGE_FILE", columnDefinition = "bytea")
    private byte[] imageFile;

}
