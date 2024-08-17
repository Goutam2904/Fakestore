package com.goutam.example.fakestoreapi.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDTO {
    private String msessage;
    private String code;

    public ErrorDTO() {
        this.msessage = msessage;
        this.code = code;
    }
}
