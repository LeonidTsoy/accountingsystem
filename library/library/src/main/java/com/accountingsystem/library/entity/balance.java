package com.accountingsystem.library.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "balance")
public class balance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String master;

    @Column
    private int amount;

    @Column
    private String fixationDate;

    @Column
    private String accountType;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id")
    private users users;

}