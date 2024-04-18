package com.project.sbLearn.Repository;

import com.project.sbLearn.Entity.ProfilePictureEntity;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfilePictureRepository extends JpaRepository <ProfilePictureEntity, String>{
    Optional<ProfilePictureEntity> findByimgName(String name);
}
