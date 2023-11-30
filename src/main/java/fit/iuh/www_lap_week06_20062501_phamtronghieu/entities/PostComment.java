package fit.iuh.www_lap_week06_20062501_phamtronghieu.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "post_comments")
public class PostComment  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "postId")
    private Post post;


    @ManyToOne
    @JoinColumn(name = "parentId")
    private PostComment parent;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "createdAt", nullable = false)
    private Instant   createdAt;

    @Column(name = "published", nullable = false)
    private boolean published;

    @Column(name = "publishedAt")
    private Instant  publishedAt;

    public PostComment(User user, Post post, PostComment parent, String title, Instant createdAt, boolean published, Instant publishedAt, String content) {
        this.user = user;
        this.post = post;
        this.parent = parent;
        this.title = title;
        this.createdAt = createdAt;
        this.published = published;
        this.publishedAt = publishedAt;
        this.content = content;
    }

    @Lob
    @Column(name = "content", nullable = false)
    private String content;

    @OneToMany(mappedBy ="parent",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<PostComment> postComments ;


}