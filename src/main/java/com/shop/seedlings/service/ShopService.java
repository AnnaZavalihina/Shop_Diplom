package com.shop.seedlings.service;

import com.shop.seedlings.domain.entity.Info;
import com.shop.seedlings.domain.entity.PickupAddress;
import com.shop.seedlings.domain.entity.Question;

import java.util.List;

public interface ShopService {
    List<Question> getAllQuestions();
    Info getInfo();
    void savePickupAddress(PickupAddress pickupAddress);
    void deletePickupAddress(int id);
    List<PickupAddress> getAllPickupAddresses();
    void editInfo(Info info);
    void saveQuestion(Question question);
}
