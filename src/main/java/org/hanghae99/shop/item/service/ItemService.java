package org.hanghae99.shop.item.service;

import lombok.AllArgsConstructor;
import org.hanghae99.shop.item.dto.ApiResponseDto;
import org.hanghae99.shop.item.dto.ItemRequestDto;
import org.hanghae99.shop.item.dto.ItemResponseDto;
import org.hanghae99.shop.item.entity.Item;
import org.hanghae99.shop.item.repository.ItemRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemResponseDto createItem(ItemRequestDto itemRequestDto) {
        Item item = new Item(itemRequestDto);
        itemRepository.save(item);
        return new ItemResponseDto(item);
    }

    public List<ItemResponseDto> getItems() {
        return itemRepository.findAll().stream().map(ItemResponseDto::new).toList();
    }

    @Transactional
    public ItemResponseDto updateItem(Long id, ItemRequestDto itemRequestDto) {
        Item item = itemRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        item.update(itemRequestDto);
        itemRepository.save(item);
        return new ItemResponseDto(item);
    }

    public ApiResponseDto deleteItem(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        itemRepository.delete(item);
        return new ApiResponseDto("삭제완료", HttpStatus.OK.value());
    }
}
