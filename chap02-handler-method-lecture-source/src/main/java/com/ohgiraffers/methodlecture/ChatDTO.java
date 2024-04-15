package com.ohgiraffers.methodlecture;

public class ChatDTO {

    private int no;
    private String message;

    public ChatDTO() {
    }

    public ChatDTO(int no, String message) {
        this.no = no;
        this.message = message;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ChatDTO{" +
                "no=" + no +
                ", message='" + message + '\'' +
                '}';
    }
}
