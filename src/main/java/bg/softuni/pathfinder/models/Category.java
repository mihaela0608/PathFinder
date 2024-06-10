package bg.softuni.pathfinder.models;

import bg.softuni.pathfinder.models.enums.CategoryType;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{
    //name - Accepts String values (PEDESTRIAN, BICYCLE, MOTORCYCLE, CAR)
    //
    //· description - Accepts very long String values
    @Enumerated(EnumType.STRING)
    private CategoryType name;
    @Column(columnDefinition = "TEXT")
    private String description;

    public CategoryType getName() {
        return name;
    }

    public void setName(CategoryType name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
