package com.example.demo.testControllers;

import com.example.demo.controllers.CartController;
import com.example.demo.model.persistence.Cart;
import com.example.demo.model.persistence.Item;
import com.example.demo.model.persistence.User;
import com.example.demo.model.persistence.UserOrder;
import com.example.demo.model.persistence.repositories.CartRepository;
import com.example.demo.model.persistence.repositories.ItemRepository;
import com.example.demo.model.persistence.repositories.UserRepository;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CartTest {

    @InjectMocks
    private CartController cartController;

    @Mock
    private UserRepository userRepository;

    @Mock
    private CartRepository cartRepository;

    @Mock
    private ItemRepository itemRepository;

    @Before
    public void setup(){

        when(userRepository.findByUsername("fymo")).thenReturn(createUser());
        when(itemRepository.findById(any())).thenReturn(Optional.of(createItem(1)));

    }

    public CartTest() {
    }

    public static User createUser() {
        User user = new User();
        user.setId(1L);
        user.setUsername("fymo");
        user.setPassword("password");
        user.setCart(createCart(user));

        return user;
    }

    public static Cart createCart(User user) {
        Cart cart = new Cart();
        cart.setId(1L);
        List<Item> items = createItems();
        cart.setItems(createItems());
        cart.setTotal(items.stream().map(item -> item.getPrice()).reduce(BigDecimal::add).get());
        cart.setUser(user);

        return cart;
    }

    public static List<Item> createItems() {

        List<Item> items = new ArrayList<>();

        for (int i = 1; i <= 2; i++) {
            items.add(createItem(i));
        }

        return items;
    }

    public static Item createItem(long id){
        Item item = new Item();
        item.setId(id);

        item.setPrice(BigDecimal.valueOf(id * 1.2));

        item.setName("Item " + item.getId());

        item.setDescription("Description ");
        return item;
    }

    public static List<UserOrder> createOrders(){
        List<UserOrder> orders = new ArrayList<>();

        IntStream.range(0,2).forEach(i -> {
            UserOrder order = new UserOrder();
            Cart cart = createCart(createUser());

            order.setItems(cart.getItems());
            order.setTotal(cart.getTotal());
            order.setUser(createUser());
            order.setId(Long.valueOf(i));

            orders.add(order);
        });
        return orders;
    }
}
