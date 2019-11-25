package com.agharibi.hibernate.inheritance;

import javax.persistence.*;


/**
 * Single mapping table
 * Map all entities in inheritance tree to a single database table
 * A discriminator column indicates the type/class of data in the row
 * Table has columns for all the fields in the inheritance tree.
 * Each row will only use a subset of the fields
 * Unused fields are set to null.
 */

@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // this is the default in inheritance
@DiscriminatorColumn(name = "DTYPE", discriminatorType = DiscriminatorType.STRING)  // default is DTYPE
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    public User() {
    }

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return id + ", " + firstName + ", " + lastName + ", " + email;
    }
}
