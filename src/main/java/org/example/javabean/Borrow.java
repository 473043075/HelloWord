package org.example.javabean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Borrow {
    private String  bookname;
    private Date borrow_date;
    private Date end_data;
    private Date return_data;
    private String illegal;
    private String manager;
}
