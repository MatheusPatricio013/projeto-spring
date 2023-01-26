package com.minispring.minispring.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@Table(name="instruction")
public class Instruction implements Serializable {
    private static final Long serialVersionUID = 1L;

    private static final String OBJECT_TYOE = "INSTRUCTION";
    @Id
    @GeneratedValue(generator = "settlementInstructionGenerator",strategy = GenerationType.SEQUENCE)
    @Column(name="id",insertable = true,updatable = false,nullable = false)
    private Long id;
    @Column(name="date",nullable = true)
    private Timestamp date;
    @Column(name="dueDate",nullable = true)
    private LocalDateTime dueDate;
    @Column(name="externalReference",nullable = false)
    private String externalReference;

}
