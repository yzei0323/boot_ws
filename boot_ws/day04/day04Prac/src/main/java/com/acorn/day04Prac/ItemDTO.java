package com.acorn.day04Prac;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemDTO {
    String title;
    String link;
    String image;
    String lprice;
}
