package com.hello.kurly.common.exception;

public class ProductNotFoundException extends BusinessException {

  public ProductNotFoundException(String message) {
    super(message, ErrorCode.PRODUCT_NOT_FOUND);
  }

  public ProductNotFoundException() {
    super(ErrorCode.PRODUCT_NOT_FOUND);
  }
}
