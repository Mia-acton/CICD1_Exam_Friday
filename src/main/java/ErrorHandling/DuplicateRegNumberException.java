package com.example.cic1_lab_exam.ErrorHandling;

public class DuplicateRegNumberException extends RuntimeException {
    private String msg;
    private String field;

    public DuplicateRegNumberException(String msg, String field) {
        this.msg = msg;
        this.field = field;
    }

    public DuplicateRegNumberException(String msg) {
        super(msg);
        this.msg = msg;
    }
}

