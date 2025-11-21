package com.example.cic1_lab_exam.ErrorHandling;

public class BookingNotFoundException extends RuntimeException {
    private String msg;
    private String field;

    public BookingNotFoundException(String msg, String field) {
        this.msg = msg;
        this.field = field;
    }

    public BookingNotFoundException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
