package com.shop.seedlings.service;

import com.shop.seedlings.domain.entity.Subtype;
import com.shop.seedlings.domain.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.shop.seedlings.dao.ItemDao;
import com.shop.seedlings.domain.entity.Item;

import java.util.List;

@Service
public class ItemServiceImp implements ItemService {

    @Autowired
    private ItemDao itemDao;

    @Override
    @Transactional
    public List<Item> getAllItems() {
        return itemDao.getAllItems();
    }


    @Override
    @Transactional
    public void saveItem(Item item) {
        itemDao.saveItem(item);
    }

    @Override
    @Transactional
    public void deleteItem(int id) {
        itemDao.deleteItem(id);
    }

    @Override
    @Transactional
    public List<Item> getAllDiscountItems() {
        return itemDao.getAllDiscountItems();
    }

    @Override
    @Transactional
    public List<Type> getAllTypes() {
        return itemDao.getAllTypes();
    }

    @Override
    @Transactional
    public List<Subtype> getAllSubtypes(int typeId) {
        return itemDao.getAllSubtypes(typeId);
    }

    @Override
    @Transactional
    public List<Subtype> getSubtypes() {
        return itemDao.getSubtypes();
    }

    @Override
    @Transactional
    public List<Item> getAllSubtypeItems(int subtypeId) {
        return itemDao.getAllSubtypeItems(subtypeId);
    }

    @Override
    @Transactional
    public List<Item> getAllTypeItems(int typeId) {
        return itemDao.getAllTypeItems(typeId);
    }

    @Override
    @Transactional
    public Type getTypeById(int id) {
        return itemDao.getTypeById(id);
    }

    @Override
    @Transactional
    public Subtype getSubtypeById(int id) {
        return itemDao.getSubtypeById(id);
    }


    @Override
    @Transactional
    public Item getItemById(int id) {
        return itemDao.getItemById(id);
    }

}