package com.innowise.inventoryservice.controller;

import com.innowise.inventoryservice.dto.InventoryResponse;
import com.innowise.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/api/inventory")
    @RequiredArgsConstructor
    @Slf4j
    public class InventoryController {

        private final InventoryService inventoryService;

        // http://localhost:0/api/inventory/sofa,sofa_pink

        // http://localhost:0/api/inventory?skuCode=sofa&skuCode=sofa_pink
        @GetMapping
        @ResponseStatus(HttpStatus.OK)
        public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode) {
            log.info("Received inventory check request for skuCode: {}", skuCode);
            return inventoryService.isInStock(skuCode);
        }
    }

