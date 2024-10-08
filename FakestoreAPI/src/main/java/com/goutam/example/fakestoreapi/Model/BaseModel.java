package com.goutam.example.fakestoreapi.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {

    @Id
    @GeneratedValue(strategy  = GenerationType.AUTO)

    private Long id;
    private Date createDate;
    private Date lastUpdateDate;
    private boolean isDeleted;

}
