package rest.webservices.webservices.repository;

import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;
import rest.webservices.webservices.entities.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDao {

    private static List<User> users = new ArrayList<>();

    static{
        users.add(new User(1,"Carlos", LocalDate.now()));
        users.add(new User(2,"Ana", LocalDate.now()));
        users.add(new User(3,"Joao", LocalDate.now()));
    }
    public List<User> findAll() {
        return users;
    }

    public User getOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id) ;
        return users.stream()
                .filter(predicate)
                .findFirst()
                .orElse(null);
    }

    public void deleteOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id) ;
        users.removeIf(predicate);
    }

    public void save(User user){
        users.add(user);
    }
}
