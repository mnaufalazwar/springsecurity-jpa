package com.mnaufalazwar.springsecurityjpa.dto;

import java.io.Serializable;

public class ResponseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    String code;

    String data;

    public ResponseDto(String code, String data) {
        super();
        this.code = code;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
