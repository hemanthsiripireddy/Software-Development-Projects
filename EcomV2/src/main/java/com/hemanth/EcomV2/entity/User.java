package com.hemanth.EcomV2.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column(unique = true)
    private String userName;
    private String password;
    private String mail;

    private String name;
    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @OneToOne
    @JoinColumn(name = "wishList_id")
    private WishList wishList;
    private int defaultAddressId;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Address> addresses;
    //added
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Orders> orders = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private UserType userType;

    public boolean addAddress(Address address){
        if(addresses==null){
            addresses=new ArrayList<>();
        }
        addresses.add(address);
        return true;
    }

}
