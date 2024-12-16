package edu.miu.cs.najeeb.spring.examprep.dto;

public class ErrorDto {
    private int code;
    private String message;

    public ErrorDto() {
    }

    public ErrorDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
