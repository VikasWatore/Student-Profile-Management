package com.dailycodework.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "please enter the firstName")
    private String firstName;
    @NotBlank(message = "please enter the lastName")
    private String lastName;
    @NaturalId(mutable = true)
    @NotBlank(message = "please enter the email")
    private String email;
    @NotBlank(message = "please enter the department")
    private String department;

}
