package bg.softuni.pathfinder.models.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

public class UserRegisterDto {
    @Size(min = 2, max = 20)
    @NotEmpty
    private String username;
    @Size(min = 2, max = 20)
    @NotEmpty
    private String password;
    @Min(0)
    @Max(90)
    @NotNull
    private Integer age;

    @Size(min = 2)
    @NotEmpty
    private String fullName;
    @NotEmpty
    @Email
    private String email;
    private String confirmPassword;

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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
}
