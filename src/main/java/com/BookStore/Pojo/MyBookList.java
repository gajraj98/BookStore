package com.BookStore.Pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "MyBooks")
public class MyBookList {

    @Id
    private int id;
    private String name;
    private String author;
    private String price;
}
