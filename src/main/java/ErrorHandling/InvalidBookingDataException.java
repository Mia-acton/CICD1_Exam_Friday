package com.example.cic1_lab_exam.ErrorHandling;

public class InvalidBookingDataException extends RuntimeException {
  private String msg;
  private String field;

  public InvalidBookingDataException(String msg, String field) {
    this.msg = msg;
    this.field = field;
  }

  public InvalidBookingDataException(String msg) {
    super(msg);
    this.msg = msg;
  }
}
