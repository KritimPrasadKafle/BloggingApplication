package com.springboot.blog.entity;
import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(
        name = "posts", uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})}
)
public class Post {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "content", nullable = false)
    private String content;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments = new HashSet<>();

//    FetchType.Lazy means we load the post entity, then its category won't load immediately.'
    @ManyToOne(fetch=FetchType.LAZY)
    //JoinColumn for specifying the foreign key. foreign key name as a category_id.
    //Onetomany mapping, we have to create a foreign key in a child table.
    //Here, Category is basically a parent table and Post is basically a child table.
    //Inorder to define the one to many mapping between these two tables,
    // then we have to create a foreign key, a child table that is in a Post table.
    //That's why we have specified the foreign key by using @JoinColumn annotation.
    //Next we have to define one to many mapping between Category and Post as this is the one to main bidirectional.
    @JoinColumn(name = "category_id")
    private Category category;
}
