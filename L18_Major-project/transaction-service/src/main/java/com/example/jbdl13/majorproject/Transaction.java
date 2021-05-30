package com.example.jbdl13.majorproject;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String transactionId;

    private String fromUser;
    private String toUser;
    private int amount;

    private String purpose;

    @CreationTimestamp
    private Date transactionDate;

    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;

}
