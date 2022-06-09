package com.shop.seedlings.dao;

import com.shop.seedlings.domain.entity.Answer;
import com.shop.seedlings.domain.entity.Info;
import com.shop.seedlings.domain.entity.PickupAddress;
import com.shop.seedlings.domain.entity.Question;

import java.util.List;

public interface ShopDao {
    List<Question> getAllQuestions();
    Info getInfo();
    void editInfo(Info info);
    void savePickupAddress(PickupAddress pickupAddress);
    void deletePickupAddress(int id);
    List<PickupAddress> getAllPickupAddresses();
    void saveQuestion(Question question);
    Answer getAnswerById(int id);
}
