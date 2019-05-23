package models;

import java.util.*;
import javax.persistence.*;

import io.ebean.*;
import javafx.concurrent.Task;
import play.data.format.*;
import play.data.validation.*;

@Entity(name = "user_acc")
public class UserEntity extends Model {

    @Id
    public Long id;

    @Column(name = "user_login")
    @Constraints.Required
    public String login;

    @Column(name = "user_password")
    @Constraints.Required
    public String password;

    @Column(name = "user_email")
    @Constraints.Required
    public String email;

    @Column(name = "user_status")
    @Constraints.Required
    Long status;

    public static final Finder<Long, UserEntity> find = new Finder<>(UserEntity.class);

    // Find all users
    public List<UserEntity> findAll() {
        return UserEntity.find.all();
    }

    // Find a user by ID
    public UserEntity findById(Long userId) {
        return UserEntity.find.byId(userId);
    }

    // Delete a user by ID
    public void deleteUser(Long userId) {
        UserEntity.find.ref(userId).delete();
    }
}
