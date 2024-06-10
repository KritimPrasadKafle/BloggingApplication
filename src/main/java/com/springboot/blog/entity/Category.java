package com.springboot.blog.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    //mappedBy attribute says that is we are using one to many bidirectional mapping and don't create the additional join tables.
    //Cascade type has different operations like persist, merge, remove, refresh, detach.
    //all means in cascade all these operations and whenever we perform these operations on parent entity, it will also applicable to its child as well.
    //orphanRemoval tells hibernate that remove all the orphaned enitites from the database table.
    //It means that child entities don't have the parent reference.
    //The hibernate will basically remove those child entities from the db table.
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts;
}
