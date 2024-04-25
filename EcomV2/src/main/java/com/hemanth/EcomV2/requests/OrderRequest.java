package com.hemanth.EcomV2.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {

    private int user_id;
    private int product_id;
    private int address_id;
    private int quantity;

}
