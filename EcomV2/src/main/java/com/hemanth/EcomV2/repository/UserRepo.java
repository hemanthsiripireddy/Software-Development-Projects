package com.hemanth.EcomV2.repository;

import com.hemanth.EcomV2.entity.Product;
import com.hemanth.EcomV2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    @Query(name = "User.findByUserName")
   public User findByUserName(String userName);
}
