package com.example.productsapi.dto;

import java.util.ArrayList;
import java.util.List;

public class ResponseData<T> {

    private String status;
    private List<String> message = new ArrayList<>();
    private T payload;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }
}
