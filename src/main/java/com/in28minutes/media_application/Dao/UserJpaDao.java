package com.in28minutes.media_application.Dao;

import com.in28minutes.media_application.Entity.Post;
import com.in28minutes.media_application.Entity.User;
import com.in28minutes.media_application.Repositories.PostJpaRepository;
import com.in28minutes.media_application.Repositories.UserJpaRepository;
import com.in28minutes.media_application.Services.UserNotFoundException;
import com.in28minutes.media_application.Services.UserService;
import jakarta.validation.Valid;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJpaDao {

    private UserJpaRepository userJpaRepository;

    private PostJpaRepository postJpaRepository;

    public UserJpaDao(UserJpaRepository userJpaRepository,PostJpaRepository postJpaRepository) {
        this.userJpaRepository = userJpaRepository;
        this.postJpaRepository = postJpaRepository;
    }

    @GetMapping("/jpa/users")
    public List<User> retriveAllData(){
        return userJpaRepository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public User retriveUser(@PathVariable int id)
    {
        Optional<User> user = userJpaRepository.findById(id);

        if(user == null)
            throw new UserNotFoundException("Id : "+id);

        return user.get();
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> addNewUser(@Valid @RequestBody User user){
        User savedUser = userJpaRepository.save(user);

        //How Its working  /users/4  => means users is /users means path and 4 is appended id.
        // .fromCurrentRequest() this function will give /users means it will give path of current request.

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id){
        userJpaRepository.deleteById(id);
    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retriveUsersPosts(@PathVariable int id)
    {
        Optional<User>  user=userJpaRepository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("id "+id);
        }

        return user.get().getPosts();
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Post> creatingPostNewUsers(@PathVariable int id,@Valid @RequestBody Post post)
    {
        Optional<User>  user=userJpaRepository.findById(id);
        if(user.isEmpty())
            throw new UserNotFoundException("id "+id);

        post.setUser(user.get());

        Post savedPost = postJpaRepository.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();
        return ResponseEntity.created(location).build();

    }

}
