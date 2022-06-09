package com.shop.seedlings.dao;

import com.shop.seedlings.domain.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShopDaoImp implements ShopDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Info getInfo() {
        Session session = sessionFactory.getCurrentSession();
        int id = 1;
        Info info = session.get(Info.class, id);
        return info;
    }

    @Override
    public void editInfo(Info info) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(info);
    }


    @Override
    public List<Question> getAllQuestions() {
        Session session = sessionFactory.getCurrentSession();
        Query<Question> query = session.createQuery("from Question Q ORDER BY Q.id DESC", Question.class);
        List<Question> allQuestions = query.getResultList();
        return allQuestions;
    }


    @Override
    public void savePickupAddress(PickupAddress address) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(address);
    }

    @Override
    public void deletePickupAddress(int id) {
        Session session = sessionFactory.getCurrentSession();
        PickupAddress pickupAddress = session.load(PickupAddress.class, id);
        if (pickupAddress != null) {
            session.delete(pickupAddress);
        }
    }

    @Override
    public List<PickupAddress> getAllPickupAddresses() {
        Session session = sessionFactory.getCurrentSession();
        Query<PickupAddress> query = session.createQuery("from PickupAddress", PickupAddress.class);
        List<PickupAddress> allPickupAddresses = query.getResultList();
        return allPickupAddresses;
    }

    @Override
    public void saveQuestion(Question question) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(question);
    }

    @Override
    public Answer getAnswerById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Answer answer = session.get(Answer.class, id);
        return answer;
    }
}