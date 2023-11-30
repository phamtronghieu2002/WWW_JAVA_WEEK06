package fit.iuh.www_lap_week06_20062501_phamtronghieu.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "posts")
@Data
@ToString(exclude = {"author", "parent", "posts", "postComments"})
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "metaTitle", nullable = false)
    private String metaTitle;


    @Column(name = "createdAt", nullable = false)
    private Instant createdAt;

    @Column(name = "published", nullable = false)
    private boolean published;

    @Lob
    @Column(name = "summary", nullable = false)
    private boolean summary;

    @Column(name = "publishedAt")
    private Instant  publishedAt;

    @Column(name = "updatedAt")
    private Instant  updatedAt;



    @ManyToOne
    @JoinColumn(name = "authorId")
    private User author;

    @ManyToOne
    @JoinColumn(name = "parentId")
    private Post parent;

    @OneToMany(mappedBy = "parent",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Post> posts;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<PostComment> postComments ;


    public Post(String content, String title, String metaTitle, Instant createdAt, boolean published, boolean summary, Instant publishedAt, Instant updatedAt, User author, Post parent) {
        this.content = content;
        this.title = title;
        this.metaTitle = metaTitle;
        this.createdAt = createdAt;
        this.published = published;
        this.summary = summary;
        this.publishedAt = publishedAt;
        this.updatedAt = updatedAt;
        this.author = author;
        this.parent = parent;
    }
}