package com.draquio.jwt_api.repositories.interfaces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.draquio.jwt_api.models.User;

@Repository
public interface IAuthRepository extends JpaRepository<User, Long> {

}
