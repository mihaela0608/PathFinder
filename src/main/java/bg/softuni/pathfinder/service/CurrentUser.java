package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.models.User;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
public class CurrentUser {
    private User user;
    public boolean isLoggedIn(){
        return user != null;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
