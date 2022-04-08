package com.example.demo.Utility;

import com.example.demo.model.persistence.Cart;
import com.example.demo.model.persistence.Item;
import com.example.demo.model.persistence.User;
import com.example.demo.model.persistence.UserOrder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Util {

    public static User createUser() {
        User user = new User();
        user.setId(1L);
        user.setUsername("userTest");
        user.setPassword("password");
        user.setCart(createCart(user));

        return user;
    }

    public static Cart createCart(User user) {
        Cart cart = new Cart();
        cart.setId(1L);
        List<Item> itemTests = createItems();
        cart.setItems(createItems());
        cart.setTotal(itemTests.stream().map(Item::getPrice).reduce(BigDecimal::add).get());
        cart.setUser(user);

        return cart;
    }

    public static List<Item> createItems() {

        List<Item> itemTests = new ArrayList<>();

        for (int i = 1; i <= 2; i++) {
            itemTests.add(createItem(i));
        }

        return itemTests;
    }

    public static Item createItem(long id){
        Item itemTest = new Item();
        itemTest.setId(id);

        itemTest.setPrice(BigDecimal.valueOf(id * 1.2));

        itemTest.setName("itemTest " + itemTest.getId());

        itemTest.setDescription("Description ");
        return itemTest;
    }

    public static List<UserOrder> createOrders(){
        List<UserOrder> orders = new ArrayList<>();

        IntStream.range(0,2).forEach(i -> {
            UserOrder order = new UserOrder();
            Cart cart = createCart(createUser());

            order.setItems(cart.getItems());
            order.setTotal(cart.getTotal());
            order.setUser(createUser());
            order.setId((long) i);

            orders.add(order);
        });
        return orders;
    }
}
