package com.example.blogService.articleService.dto;

public class ResponseObject<T> {
    private String code;
    private String msg;
    private T data;

    public ResponseObject() {

    }

    public ResponseObject(T... data) {
        this.code = "0";
        this.msg = "success";
        if (data.length > 0) {
            this.data = data[0];
        }
    }


    public ResponseObject(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseObject(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
