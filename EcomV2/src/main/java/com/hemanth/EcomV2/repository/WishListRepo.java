package com.hemanth.EcomV2.repository;

import com.hemanth.EcomV2.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishListRepo extends JpaRepository<WishList,Integer> {

}
