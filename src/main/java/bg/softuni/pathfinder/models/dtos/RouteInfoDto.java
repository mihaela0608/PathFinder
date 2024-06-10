package bg.softuni.pathfinder.models.dtos;

import bg.softuni.pathfinder.models.Category;
import bg.softuni.pathfinder.models.User;
import bg.softuni.pathfinder.models.enums.Level;
import jakarta.persistence.*;

import java.util.List;

public class RouteInfoDto {
    private String name;

    private String description;
    private String pictureUrl;

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
