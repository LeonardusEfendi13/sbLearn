package com.project.sbLearn.Service;

import com.project.sbLearn.Entity.AccountEntity;
import com.project.sbLearn.Entity.ProfilePictureEntity;
import com.project.sbLearn.Repository.AccountRepository;
import com.project.sbLearn.Repository.ProfilePictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;

@Service
public class ProfileService {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ProfilePictureRepository profilePictureRepository;

    public boolean isEmailUnique(String email, String uid) {
        // Check if the email is unique among all existing values except for the specified uid
        return !accountRepository.existsByEmailAndUidNot(email, uid);
    }

    public byte[] getImageFromDb(String imgName) {
        Optional<ProfilePictureEntity> profilePictureOptional = profilePictureRepository.findByimgName(imgName);
        if (profilePictureOptional.isPresent()) {
            ProfilePictureEntity profilePicture = profilePictureOptional.get();
            return profilePicture.getImageFile();
        } else {
            return null;
        }
    }

    public byte[] decodeBase64String(String base64String) {
        return Base64.getDecoder().decode(base64String);
    }

    public void changeProfilePicture(String imageName, String userName) {
        AccountEntity accountEntity = accountRepository.findByUsername(userName);
        if (accountEntity != null) {
            System.out.println("ada akun");
            accountEntity.setProfilePictureName(imageName);
            accountRepository.save(accountEntity);
        } else {
            System.out.println("gaada akun");
        }
    }

    public void setBadgeUser(String uid){
        Optional<AccountEntity> accountEntityOptional = accountRepository.findByUid(uid);
        if(accountEntityOptional.isPresent()){
            AccountEntity accountEntity = accountEntityOptional.get();
            if(accountEntity.getExp() < 30){
                accountEntity.setBadge("Bronze");
            }else if(accountEntity.getExp() < 65){
                accountEntity.setBadge("Silver");
            }else if(accountEntity.getExp() < 125){
                accountEntity.setBadge("Gold");
            }else if (accountEntity.getExp() < 205){
                accountEntity.setBadge("Platinum");
            }else {
                accountEntity.setBadge("Diamond");
            }
            System.out.println("badge : " +accountEntity.getBadge());
            accountRepository.save(accountEntity);
        }else{
            System.out.println("No account found with : "+uid);
        }
    }
}
