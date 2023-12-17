package com.memorybox.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

@Service
public class UserIdService {
    private final ConcurrentLinkedDeque<Integer> userIdQueue = new ConcurrentLinkedDeque<>();
    private final ConcurrentLinkedDeque<Integer> specialIdQueue = new ConcurrentLinkedDeque<>();

    @PostConstruct
    private void init() {
        for (int userId = 1; userId <= 10; userId++) {
            userIdQueue.offer(userId);
        }
        specialIdQueue.addAll(List.of(111, 112, 113));
    }

    public String getUserId() {
        Integer userId = userIdQueue.pop();
        userIdQueue.offer(userId);
        return userId.toString();
    }

    public String getSpecialUserId() {
        Integer userId = specialIdQueue.pop();
        specialIdQueue.offer(userId);
        return userId.toString();
    }

}