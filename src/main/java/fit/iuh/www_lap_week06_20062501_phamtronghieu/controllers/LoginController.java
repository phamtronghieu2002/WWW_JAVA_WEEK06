package fit.iuh.www_lap_week06_20062501_phamtronghieu.controllers;


import fit.iuh.www_lap_week06_20062501_phamtronghieu.entities.Post;
import fit.iuh.www_lap_week06_20062501_phamtronghieu.entities.User;
import fit.iuh.www_lap_week06_20062501_phamtronghieu.repositories.PostRepository;
import fit.iuh.www_lap_week06_20062501_phamtronghieu.repositories.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;
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


}