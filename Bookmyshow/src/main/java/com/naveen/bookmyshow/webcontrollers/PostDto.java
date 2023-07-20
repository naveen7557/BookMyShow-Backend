package com.naveen.bookmyshow.webcontrollers;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostDto {

    private Long id;
    private String movieName;
    private String image;
    private String language;

    private String genre;
    private String rating ;
    private String description;
}
