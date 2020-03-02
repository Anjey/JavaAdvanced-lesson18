package com.barca.ss.domain;

import java.util.Objects;

public class Participant {
    private Integer id;
    private String name;
    private String email;
    private Level level;
    private String primarySkill;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getPrimarySkill() {
        return primarySkill;
    }

    public void setPrimarySkill(String primarySkill) {
        this.primarySkill = primarySkill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return id.equals(that.id) &&
                name.equals(that.name) &&
                email.equals(that.email) &&
                level == that.level &&
                primarySkill.equals(that.primarySkill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, level, primarySkill);
    }

    @Override
    public String toString() {
        return "Participant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", level=" + level +
                ", primarySkill='" + primarySkill + '\'' +
                '}';
    }
}
