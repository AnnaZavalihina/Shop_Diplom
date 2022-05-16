package web.spring.shop.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.spring.shop.dao.ItemDao;
import web.spring.shop.entity.Item;

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
    public Item getItemById(int id) {
        return itemDao.getItemById(id);
    }

}