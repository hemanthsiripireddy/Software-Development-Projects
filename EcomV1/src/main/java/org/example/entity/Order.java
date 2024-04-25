package org.example.entity;

import java.util.List;
import java.util.Map;

public class Order {

    private int orderId;
    private int userId;

    private Map<Integer,Integer> products;

    private double totalPrice;
    private Status status;
    private String Address;
}
