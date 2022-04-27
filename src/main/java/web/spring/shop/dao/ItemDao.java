package web.spring.shop.dao;

import web.spring.shop.entity.Item;

import java.util.List;

public interface ItemDao {
    Item getItemById(int id);
    List<Item> getAllItems();
    void saveItem(Item item);
    void deleteItem(int id);
}
