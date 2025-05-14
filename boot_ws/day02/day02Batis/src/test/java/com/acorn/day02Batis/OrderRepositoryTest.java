package com.acorn.day02Batis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderRepositoryTest {
    @Autowired
    OrderRepository orderRepository;

    @Test
    public void test() {
        int size = orderRepository.selectAll().size();
        assertTrue(size >= 1);
    }
}
