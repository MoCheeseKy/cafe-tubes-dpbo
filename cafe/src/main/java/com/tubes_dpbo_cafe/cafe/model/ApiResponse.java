package com.tubes_dpbo_cafe.cafe.model;

import java.util.List;

public class ApiResponse<T> {
    private T data;
    private int status;
    private String message;
    private int page;
    private long totalData;

    public ApiResponse() {}

    public ApiResponse(T data, int status, String message, int page, long totalData) {
        this.data = data;
        this.status = status;
        this.message = message;
        this.page = page;
        this.totalData = totalData;
    }

    // Getters and Setters
    public T getData() { return data; }
    public void setData(T data) { this.data = data; }

    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public int getPage() { return page; }
    public void setPage(int page) { this.page = page; }

    public long getTotalData() { return totalData; }
    public void setTotalData(long totalData) { this.totalData = totalData; }
}
