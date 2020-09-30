package com.example.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Grzegorz Nowakowski
 */

@Entity
@Table
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String lastName;
    private String github;
    private String start;
    private int java;
    private int bestpractice;
    private int tdd;
    private int question;
    private int hibernate;
    private int html;
    private int jsp;
    private int thymeleaf;
    private int git;
    private int checkbox;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "person")
    private Set<Items> items = new HashSet<Items>();


    public Person() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public int getJava() {
        return java;
    }

    public void setJava(int java) {
        this.java = java;
    }

    public int getBestpractice() {
        return bestpractice;
    }

    public void setBestpractice(int bestpractice) {
        this.bestpractice = bestpractice;
    }

    public int getTdd() {
        return tdd;
    }

    public void setTdd(int tdd) {
        this.tdd = tdd;
    }

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

    public int getHibernate() {
        return hibernate;
    }

    public void setHibernate(int hibernate) {
        this.hibernate = hibernate;
    }

    public int getHtml() {
        return html;
    }

    public void setHtml(int html) {
        this.html = html;
    }

    public int getJsp() {
        return jsp;
    }

    public void setJsp(int jsp) {
        this.jsp = jsp;
    }

    public int getThymeleaf() {
        return thymeleaf;
    }

    public void setThymeleaf(int thymeleaf) {
        this.thymeleaf = thymeleaf;
    }

    public int getGit() {
        return git;
    }

    public void setGit(int git) {
        this.git = git;
    }

    public int getCheckbox() {
        return checkbox;
    }

    public void setCheckbox(int checkbox) {
        this.checkbox = checkbox;
    }

    public Set<Items> getItems() {
        return items;
    }

    public void setItems(Set<Items> items) {
        this.items = items;
    }
}
