package com.project.sbLearn.Repository;

import com.project.sbLearn.Entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, String> {
    AccountEntity findByUsername(String username);
    AccountEntity findNameByUsername(String username);

    Optional<AccountEntity> findByUid(String u_id);
    AccountEntity findByEmail(String email);

    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

    boolean existsByEmailAndUidNot(String email, String uid);

}
