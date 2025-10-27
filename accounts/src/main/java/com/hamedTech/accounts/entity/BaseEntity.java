package com.hamedTech.accounts.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
@MappedSuperclass
public class BaseEntity {

     private LocalDateTime createdAt;
     private String createdBy;
     private LocalDateTime updatedAt;
     private String updatedBy;

}
