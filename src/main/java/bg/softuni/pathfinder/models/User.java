package bg.softuni.pathfinder.models;

import bg.softuni.pathfinder.models.enums.Level;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity{
    //username - Accepts String values
    //
    //o Accepts values, which should be at least 2 characters
    //
    //· password - Accepts String values
    //
    //o Accepts values, which should be at least 2 characters
    //
    //· full name - Accepts String values
    //
    //o Accepts values, which should be at least 2 characters
    //
    //· email - Accepts String values
    //
    //o Accepts values, which contain the '@' symbol
    //
    //· role - Accepts Role Entity values
    //
    //o Each registered user should have a "User" role
    //
    //· level - Accepts a level of the user (BEGINNER, INTERMEDIATE, ADVANCED)
    private String username;
    private String password;
    private int age;



    @Column(name = "full_name")
    private String fullName;
    private String email;



    @ManyToMany
    @JoinTable(name = "users_roles")
    private List<Role> roles;
    @Enumerated(EnumType.STRING)
    private Level level;

    public User() {
        this.roles = new ArrayList<>();
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }





    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
