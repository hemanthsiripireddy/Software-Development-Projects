package com.hemanth.EcomV2.repository;

import com.hemanth.EcomV2.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo  extends JpaRepository<Cart, Integer> {
    @Query("SELECT c FROM Cart c WHERE c.user.userId = :userId")
    Cart findByUserId(@Param("userId") int userId);
}
