package com.sofka.client.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(schema = "client")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;
    @Column(length = 13)
    private String identification;
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String lastname;
    @Column(columnDefinition = "date")
    private Date birthdate;
    private Integer age;
    @Column(length = 1)
    private String gender;
    private String address;
    @Column(length = 10)
    private String phone;
    @Column(columnDefinition = "boolean default true")
    private Boolean state;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "client_id")
    private Client client;

    public Person() {
    }

    public Person(String id, String identification, String name, String lastname, Date birthdate, Integer age, String gender, String address, String phone, Boolean state, Client client) {
        this.id = id;
        this.identification = identification;
        this.name = name;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.state = state;
        this.client = client;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}
