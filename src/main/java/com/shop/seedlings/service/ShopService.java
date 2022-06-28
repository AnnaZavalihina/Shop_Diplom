package com.shop.seedlings.service;

import com.shop.seedlings.domain.entity.Info;
import com.shop.seedlings.domain.entity.PickupAddress;

import java.util.List;

public interface ShopService {
    Info getInfo();

    List<PickupAddress> getAllPickupAddresses();
}
