package com.hello.kurly.users.v1.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
@Getter
public class AddressDto {

  private boolean isBaseDeliveryAddress;
  private String deliveryPolicy;
  private String zipCode;
  private String address;
  private String addressDetail;

  public AddressDto(boolean isBaseDeliveryAddress,
                    String deliveryPolicy,
                    String zipCode,
                    String address,
                    String addressDetail) {
    this.isBaseDeliveryAddress = isBaseDeliveryAddress;
    this.deliveryPolicy = deliveryPolicy;
    this.zipCode = zipCode;
    this.address = address;
    this.addressDetail = addressDetail;
  }
}
