package org.hanghae99.shop.item.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class ItemRequestDto {
    @NotBlank(message = "필수 입력 값입니다.")
    private String username;

    @NotBlank(message = "필수 입력 값입니다.")
    private String title;

    @NotBlank(message = "필수 입력 값입니다.")
    private String content;

    @NotBlank(message = "필수 입력 값입니다.")
    private int price;
}
