package com.vti.entity;



import javax.persistence.*;

@Entity
@Table(name = "Department")
public class Department {
    @Id
    @Column(name = "DepartmentID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;
    private String name;


}
