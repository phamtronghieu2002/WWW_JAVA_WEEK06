package fit.iuh.www_lap_week06_20062501_phamtronghieu.controllers;


import fit.iuh.www_lap_week06_20062501_phamtronghieu.entities.Post;
import fit.iuh.www_lap_week06_20062501_phamtronghieu.entities.PostComment;
import fit.iuh.www_lap_week06_20062501_phamtronghieu.entities.User;
import fit.iuh.www_lap_week06_20062501_phamtronghieu.repositories.PostCommentRepository;
import fit.iuh.www_lap_week06_20062501_phamtronghieu.repositories.PostRepository;
import fit.iuh.www_lap_week06_20062501_phamtronghieu.repositories.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostCommentRepository postCommentRepository;
    @GetMapping("/home")
    public  String home(Model model,HttpSession httpSession){
        User user = (User) httpSession.getAttribute("user");

        List<Post> posts=postRepository.findAll();
        model.addAttribute("user",user);
        model.addAttribute("posts",posts);
        return "home";
    }
    @GetMapping("/login")
    public String login(Model model, @RequestParam("username") String username, @RequestParam("password") String password, HttpSession httpSession) {
        User user =userRepository.findUserByEmailAndPasswordHash(username, password);
        System.out.println(username);
        System.out.println(password);
        System.out.println(user );
        if (user ==null) {
            System.out.println("user null");
            return "user wrong !!!";
        }

        httpSession.setAttribute("user",user);


        return "redirect:/home";



    }

    @PostMapping("/addComment")
    public  String addNewComment(Model  model,@RequestParam("comment") String comment
            ,@RequestParam("idPost") Long idPost,HttpSession httpSession)
    {

        User user = (User) httpSession.getAttribute("user");
        Post post = postRepository.findById(idPost).get();
        PostComment postComment = new PostComment(user,post,null,"comment", Instant.now(),true,Instant.now(),comment);

        postCommentRepository.save(postComment);

        return "redirect:/home";
    }
    @PostMapping("/Replycomment")
    public  String addReplyComment(Model  model,@RequestParam("comment") String comment
            ,@RequestParam("commentID") Long commentID,@RequestParam("idPost") Long idPost,HttpSession httpSession)
    {

        User user = (User) httpSession.getAttribute("user");
        Post post = postRepository.findById(idPost).get();
        PostComment postComment = postCommentRepository.findById(commentID).get();
        PostComment ReplyPostComment = new PostComment(user,post,postComment,"comment", Instant.now(),true,Instant.now(),comment);

        postCommentRepository.save(ReplyPostComment );

        return "redirect:/home";
    }

    @GetMapping("post")
    public String post(Model model,HttpSession httpSession)
    {





        User user = (User) httpSession.getAttribute("user");

        model.addAttribute("user",user);


        return "post";
    }

    @PostMapping("uploadPost")
    public  String uploadPost(HttpSession httpSession,@RequestParam("meta_title") String metaTitle, @RequestParam("title") String title, @RequestParam("content") String content) {
        User user = (User) httpSession.getAttribute("user");
        postRepository.save(new Post(content, title, metaTitle, Instant.now(), true, true, Instant.now(), Instant.now(), user, null));
        return "redirect:/home";
    }
}