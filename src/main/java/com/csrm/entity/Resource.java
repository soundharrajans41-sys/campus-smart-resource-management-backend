package com.csrm.entity;

import jakarta.persistence.*;

@Entity
public class Resource {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public String type;      // CLASSROOM, LAB, LOCKER, EQUIPMENT
    public String location;
    public boolean availability = true;
}
