package com.shop.seedlings.dao;

import com.shop.seedlings.domain.entity.Info;
import com.shop.seedlings.domain.entity.PickupAddress;

import java.util.List;

public interface ShopDao {
    Info getInfo();

    List<PickupAddress> getAllPickupAddresses();
}
