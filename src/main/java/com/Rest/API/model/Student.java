package com.Rest.API.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;



@Data
@NoArgsConstructor
//Data = @Getter, @Setter, @ToString, @EqualsAndHashCode and @RequiredArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    Long id;

    String name;

    Integer age;

    String regNo;

    String contact;

    Date dob;




}
