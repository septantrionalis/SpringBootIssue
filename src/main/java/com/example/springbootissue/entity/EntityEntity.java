package com.example.springbootissue.entity;

import com.example.springbootissue.enums.HierarchyType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
@Table(name = "entity", schema = "credential_management")
public class EntityEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;

    private UUID guid;

    private String name;

    private String code;

    @Enumerated(EnumType.STRING)
    private HierarchyType type;

    @Column(name = "db2_entity_id")
    private Integer db2EntityId;

    private String externalRefId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(
            name = "entity_relationship", schema = "credential_management",
            joinColumns = @JoinColumn(name = "child_entity_id"),
            inverseJoinColumns = @JoinColumn(name = "parent_entity_id")
    )
    private EntityEntity parentEntity;


}