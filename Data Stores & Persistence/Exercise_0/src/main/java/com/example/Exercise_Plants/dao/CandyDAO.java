package com.example.Exercise_Plants.dao;

import com.example.Exercise_Plants.entity.Candy;

import java.util.List;

public interface CandyDAO {
    List<Candy> list();
    void addToDelivery(Long candyId, Long deliveryid);
    List<Candy> findByDelivery(Long deliveryId);
}
