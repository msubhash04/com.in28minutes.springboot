package com.in28minutes.media_application.Services;

import com.in28minutes.media_application.Entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserService {

    private static List<User>  usersList = new ArrayList<>();
    private static int userId=0;

    {
        usersList.add(new User(++userId,"Jeo", LocalDate.now().minusYears(10)));
        usersList.add(new User(++userId,"Adm", LocalDate.now().minusYears(15)));
        usersList.add(new User(++userId,"Mark",LocalDate.now().minusYears(25)));
    }

    public List<User> findAll(){
        return usersList;
    }

  public User findUserById(int id){
        Predicate<? super User> predicate = User -> User.getId().equals(id);
        return usersList.stream().filter(predicate).findFirst().orElse(null);
  }


    public User addNewUser(User user) {
        user.setId(++userId);
        usersList.add(user);
        return user;
    }

    public void deleteById(int id) {
        Predicate<? super User> predicate=User -> User.getId().equals(id);
        usersList.removeIf(predicate);
    }
}
