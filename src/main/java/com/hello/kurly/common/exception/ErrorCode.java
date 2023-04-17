package com.hello.kurly.common.exception;

public enum ErrorCode {

  //Common
  BAD_REQUEST(400, "C001", "Invalid Request Value"),
  METHOD_NOT_ALLOWED(405, "C002", "Request Method Not Supported"),
  INTERNAL_SERVER_ERROR(500, "C003", "Server Error"),

  //Users
  USER_NOT_FOUND(400, "U001", "User Not Found"),

  //Product
  PRODUCT_NOT_FOUND(400, "P001", "Product Not Found");

  private final int status;
  private final String code;
  private final String message;

  ErrorCode(int status, String code, String message) {
    this.status = status;
    this.code = code;
    this.message = message;
  }

  public int getStatus() {
    return status;
  }

  public String getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }
}
