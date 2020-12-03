package com.accountingsystem.library.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "transactions")
public class transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactionsId;

    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "fromUser", nullable = false)
    private String fromUser;

    @Column(name = "accountFromUser", nullable = false)
    private Integer accountFromUser;

    @Column(name = "toUser", nullable = false)
    private String toUser;

    @Column(name = "accountToUser", nullable = false)
    private Integer accountToUser;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "vcComment", nullable = false)
    private String vcComment;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id")
    private users users;

}

