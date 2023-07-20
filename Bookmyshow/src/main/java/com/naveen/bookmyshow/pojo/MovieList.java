package com.naveen.bookmyshow.pojo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String movieName;
    @NotBlank
    private String image;
    @NotBlank
    private String language;
    @NotBlank
    private String genre;
    @NotBlank
    private String rating;
    @NotBlank
    @Column(length = 10000)
    private String description;

}
