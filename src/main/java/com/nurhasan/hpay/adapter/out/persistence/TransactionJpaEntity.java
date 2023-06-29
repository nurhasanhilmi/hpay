package com.nurhasan.hpay.adapter.out.persistence;

import com.nurhasan.hpay.application.domain.model.TransactionStatus;
import com.nurhasan.hpay.application.domain.model.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "transactions")
@Data
@AllArgsConstructor
@NoArgsConstructor
class TransactionJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private AccountJpaEntity account;

    private Double amount;

    private String description;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "modified_at", nullable = false)
    @LastModifiedDate
    private LocalDateTime modifiedAt;
}
