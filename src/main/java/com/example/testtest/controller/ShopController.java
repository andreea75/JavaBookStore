package com.example.testtest.controller;

import com.example.testtest.service.shop.ShopServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/shop")
public class ShopController {
    private final ShopServiceImpl shopService;

    public ShopController(ShopServiceImpl shopService) {
        this.shopService = shopService;
    }

    @PostMapping("/{bookId}")
    public ResponseEntity<?> buyBook(@PathVariable Long bookId, @RequestParam int no) {
        return ResponseEntity.ok(shopService.buyBook(bookId, no));
    }
}
