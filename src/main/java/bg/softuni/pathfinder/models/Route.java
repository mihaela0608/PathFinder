package bg.softuni.pathfinder.models;

import bg.softuni.pathfinder.models.enums.Level;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "routes")
public class Route extends BaseEntity{
    //· gpx coordinates - Accepts very long text values
    //
    //· level - Accepts the levels of the routes (BEGINNER, INTERMEDIATE, ADVANCED) as values
    //
    //· name - Accepts String values
    //
    //· author - Accepts User Entities as values
    //
    //· video url – Accepts the ids of youtube videos as values
    @Column(name = "gpx_coordinates", columnDefinition = "LONGTEXT")
    private String gpxCoordinates;
    @Enumerated(EnumType.STRING)
    private Level level;
    private String name;
    @ManyToOne
    private User author;
    @Column(name = "video_url")
    private String videoUrl;
    @ManyToMany
    @JoinTable(name = "routes_categories")
    private List<Category> categories;
    @Column(columnDefinition = "TEXT")
    private String description;
    @OneToMany(mappedBy = "route")
    private List<Picture> pictures;


    public Route() {
        this.categories = new ArrayList<>();
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }


    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public void setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
