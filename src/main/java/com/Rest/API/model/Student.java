package com.Rest.API.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;



@Data
@NoArgsConstructor
@AllArgsConstructor
//Data = @Getter, @Setter, @ToString, @EqualsAndHashCode and @RequiredArgsConstructor
@Entity
@Builder
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
