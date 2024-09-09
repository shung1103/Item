package org.hanghae99.shop.item.controller;

import lombok.AllArgsConstructor;
import org.hanghae99.shop.item.dto.ApiResponseDto;
import org.hanghae99.shop.item.dto.ItemRequestDto;
import org.hanghae99.shop.item.dto.ItemResponseDto;
import org.hanghae99.shop.item.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class ItemController {
    private final ItemService itemService;

    @PostMapping("/post")
    public ItemResponseDto createItem(@RequestBody ItemRequestDto itemRequestDto) {
        return itemService.createItem(itemRequestDto);
    }

    @GetMapping("/post")
    public List<ItemResponseDto> getItems() {
        return itemService.getItems();
    }

    @PutMapping("/post/{id}")
    public ItemResponseDto updateItem(@PathVariable Long id, @RequestBody ItemRequestDto itemRequestDto) {
        return itemService.updateItem(id, itemRequestDto);
    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity<ApiResponseDto> deleteItem(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.deleteItem(id));
    }
}
