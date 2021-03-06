package ru.learning.persist;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255)
    private String firstName;

    @Column(length = 255)
    private String lastName;

    @Column
    private LocalDate birthday;

    @OneToMany(
            mappedBy = "person",
            cascade = CascadeType.ALL
    )
    private List<Contact> contacts;

    @OneToMany(
            mappedBy = "client",
            cascade = CascadeType.ALL
    )
    private List<Buy> personbuy;

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String firstName, String lastName, LocalDate birthday, List<Contact> contacts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.contacts = contacts;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<Buy> getPersonbuy() {
        return personbuy;
    }

    public void setPersonbuy(List<Buy> personbuy) {
        this.personbuy = personbuy;
    }
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", contacts=" + contacts +
                '}';
    }
}
