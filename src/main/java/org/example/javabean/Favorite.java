package org.example.javabean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Favorite {
    private int favorite_id;
    private String name;
    private String author;
    private String sort;
    private String description;
}
