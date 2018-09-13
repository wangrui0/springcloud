package com.itmuch.cloud.microserviceprovideuser.repository;

import com.itmuch.cloud.microserviceprovideuser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
