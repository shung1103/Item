package org.hanghae99.shop.item.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hanghae99.shop.item.entity.Item;

@Getter
@NoArgsConstructor
public class ItemResponseDto {
    private Long id;
    private String username;
    private String title;
    private String content;
    private int price;

    public ItemResponseDto(Item item) {
        this.id = item.getId();
        this.username = item.getUsername();
        this.title = item.getTitle();
        this.content = item.getContent();
        this.price = item.getPrice();
    }
}
