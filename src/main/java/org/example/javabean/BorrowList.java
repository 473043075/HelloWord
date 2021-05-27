package org.example.javabean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowList {
    private int borrow_id;
    private String name;
    private String author;
    private String sort;
    private String description;
}
