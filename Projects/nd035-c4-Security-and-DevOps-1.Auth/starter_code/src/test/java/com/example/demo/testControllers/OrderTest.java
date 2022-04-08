package com.example.demo.testControllers;

import com.example.demo.controllers.OrderController;
import com.example.demo.model.persistence.User;
import com.example.demo.model.persistence.UserOrder;
import com.example.demo.model.persistence.repositories.OrderRepository;
import com.example.demo.model.persistence.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static com.example.demo.Utility.Util.*;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class OrderTest {

    @InjectMocks
    private OrderController orderController;

    @Mock
    private UserRepository userRepository;

    @Mock
    private OrderRepository orderRepository;

    @Before
    public void setup() {
        User user = createUser();

        when(userRepository.findByUsername("userTest")).thenReturn(user);
        when(orderRepository.findByUser(any())).thenReturn(createOrders());
    }

    @Test
    public void submit() {

        ResponseEntity<UserOrder> response = orderController.submit("userTest");
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());

        UserOrder order = response.getBody();

        assert order != null;
        assertEquals(createItems(), order.getItems());
        assertEquals(createUser().getId(), order.getUser().getId());


        verify(orderRepository, times(1)).save(order);

    }

    @Test
    public void submitInvalid() {

        ResponseEntity<UserOrder> response = orderController.submit("invalid username");
        assertNotNull(response);
        assertEquals(404, response.getStatusCodeValue());

        assertNull(response.getBody());

        verify(userRepository, times(1)).findByUsername("invalid username");
    }

    @Test
    public void getOrdersForUser() {

        ResponseEntity<List<UserOrder>> response = orderController.getOrdersForUser("userTest");
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());

        List<UserOrder> orders = response.getBody();


        assert orders != null;
        assertEquals(createOrders().size(), orders.size());

    }
}
