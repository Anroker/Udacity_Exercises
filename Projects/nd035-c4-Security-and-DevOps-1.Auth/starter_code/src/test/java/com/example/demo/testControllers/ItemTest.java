package com.example.demo.testControllers;

import com.example.demo.controllers.ItemController;
import com.example.demo.model.persistence.Item;
import com.example.demo.model.persistence.repositories.ItemRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.example.demo.Utility.Util.createItem;
import static com.example.demo.Utility.Util.createItems;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ItemTest {

    @InjectMocks
    private ItemController itemTestController;

    @Mock
    private ItemRepository itemTestRepository;

    @Before
    public void setup() {

        when(itemTestRepository.findById(1L)).thenReturn(Optional.of(createItem(1)));
        when(itemTestRepository.findAll()).thenReturn(createItems());
        when(itemTestRepository.findByName("itemTest")).thenReturn(Arrays.asList(createItem(1), createItem(2)));

    }

    @Test
    public void getItemTests() {
        ResponseEntity<List<Item>> response = itemTestController.getItems();

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        List<Item> itemTests = response.getBody();

        assertEquals(createItems(), itemTests);

        verify(itemTestRepository, times(1)).findAll();
    }

    @Test
    public void getItemTestById() {

        ResponseEntity<Item> response = itemTestController.getItemById(1L);
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());

        Item itemTest = response.getBody();
        assertEquals(createItem(1L), itemTest);

        verify(itemTestRepository, times(1)).findById(1L);
    }

    @Test
    public void getItemTestByIdInvalid() {

        ResponseEntity<Item> response = itemTestController.getItemById(10L);
        assertNotNull(response);
        assertEquals(404, response.getStatusCodeValue());

        assertNull(response.getBody());
        verify(itemTestRepository, times(1)).findById(10L);
    }

    @Test
    public void getItemTestByName() {
        ResponseEntity<List<Item>> response = itemTestController.getItemsByName("itemTest");

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        List<Item> itemTests = Arrays.asList(createItem(1), createItem(2));

        assertEquals(createItems(), itemTests);

        verify(itemTestRepository, times(1)).findByName("itemTest");
    }

    @Test
    public void getItemTestByNameInvalid() {
        ResponseEntity<List<Item>> response = itemTestController.getItemsByName("invalidItemTest");

        assertNotNull(response);
        assertEquals(404, response.getStatusCodeValue());

        assertNull(response.getBody());

        verify(itemTestRepository, times(1)).findByName("invalidItemTest");
    }

}
