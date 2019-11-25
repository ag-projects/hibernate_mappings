package com.agharibi.hibernate.model;


import org.hibernate.annotations.SortComparator;
import org.springframework.util.comparator.Comparators;

import javax.persistence.*;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

@Entity
@Table(name = "theater")
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "owner")
    private String owner;

    @Column(name = "location")
    private String location;

    @ElementCollection
    @CollectionTable(name = "image")
    @MapKeyColumn(name = "file_name") // keys
    @Column(name = "image_name")      // values
//    @SortComparator(Comparator.class)
    private SortedMap<String, String> images = new TreeMap<>();


    public Theater() { }

    public Theater(String name, String owner, String location) {
        this.name = name;
        this.owner = owner;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public SortedMap<String, String> getImages() {
        return images;
    }

    public void setImages(SortedMap<String, String> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return  id + ", " + name + ", " + owner + ", " + location;
    }
}
