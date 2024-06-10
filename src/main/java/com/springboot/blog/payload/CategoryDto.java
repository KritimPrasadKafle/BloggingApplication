package com.springboot.blog.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//dto class to transfer the data between client and server.
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    private Long id;
    private String name;
    private String description;
}


//we are creating a three tier architecture like controller
//our controller layer depends on service layer.
//and repository layer will get a crud method to perform core database operations on category JP entity.
//first we will create a repository and service and with service we will create a controller.

