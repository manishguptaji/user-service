package com.app.user_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "hobbies")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hobby {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    private String description;
}
