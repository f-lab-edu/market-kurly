package com.hello.kurly.factory;

import com.hello.kurly.products.domain.Storage;

public class StorageFactory {

  public static Storage createStorage() {
    return new Storage(1L);
  }
}
