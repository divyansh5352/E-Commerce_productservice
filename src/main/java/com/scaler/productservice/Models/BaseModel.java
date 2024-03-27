package com.scaler.productservice.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseModel implements Serializable {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)// doing this so that extra sequence table is not needed in the DB to store next sequence of ID
    private Long Id;
    private Date createdAt;
    private Date createdBy;
    private boolean isDeleted;
}
