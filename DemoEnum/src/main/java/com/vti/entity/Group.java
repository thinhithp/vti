package com.vti.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "`Group`")
public class Group implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GroupID", nullable = false)
    private Short id;

    public Group() {

    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CreateDate")
    private Date date;


    @Column(name = "GroupName", length = 50, nullable = false, unique = true)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Group{" + "id=" + id + ", date=" + date + ", name='" + name + '\'' + '}';
    }

    public Group(String name) {
        this.name = name;
this.date = new Date();
    }
}
