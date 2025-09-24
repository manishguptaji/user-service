package com.app.user_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_hobbies",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "hobby_id"})})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserHobby {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "hobby_id", nullable = false)
    private Long hobbyId;
}
