package com.example.springbootissue.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
@Table(name = "entity")
public class EntityEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(
            name = "entity_relationship",
            joinColumns = @JoinColumn(name = "child_entity_id"),
            inverseJoinColumns = @JoinColumn(name = "parent_entity_id")
    )
    private EntityEntity parentEntity;


}
