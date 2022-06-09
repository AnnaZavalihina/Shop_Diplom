package com.shop.seedlings.service;

import com.shop.seedlings.dao.ItemDao;
import com.shop.seedlings.dao.ShopDao;
import com.shop.seedlings.domain.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShopServiceImp implements ShopService{

    @Autowired
    private ShopDao shopDao;


    @Override
    @Transactional
    public Info getInfo() {
        return shopDao.getInfo();
    }

    @Override
    @Transactional
    public List<PickupAddress> getAllPickupAddresses() {
        return shopDao.getAllPickupAddresses();
    }

}
