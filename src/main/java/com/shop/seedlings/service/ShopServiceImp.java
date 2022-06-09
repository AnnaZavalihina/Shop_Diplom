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
    public List<Question> getAllQuestions() {
        return shopDao.getAllQuestions();
    }

    @Override
    @Transactional
    public Info getInfo() {
        return shopDao.getInfo();
    }

    @Override
    @Transactional
    public void savePickupAddress(PickupAddress pickupAddress) {
        shopDao.savePickupAddress(pickupAddress);
    }

    @Override
    @Transactional
    public void deletePickupAddress(int id) {
        shopDao.deletePickupAddress(id);
    }

    @Override
    @Transactional
    public List<PickupAddress> getAllPickupAddresses() {
        return shopDao.getAllPickupAddresses();
    }

    @Override
    @Transactional
    public void editInfo(Info info) {
        shopDao.editInfo(info);
    }

    @Override
    @Transactional
    public void saveQuestion(Question question) {
        shopDao.saveQuestion(question);
    }

    @Override
    @Transactional
    public Answer getAnswerById(int id) {
        return shopDao.getAnswerById(id);
    }
}
