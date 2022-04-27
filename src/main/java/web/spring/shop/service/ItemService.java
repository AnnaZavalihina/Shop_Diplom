package web.spring.shop.service;

import web.spring.shop.entity.Item;

import java.util.List;

public interface ItemService {
    Item getItemById(int id);
    List<Item> getAllItems();
    void saveItem(Item item);
    void deleteItem(int id);
}
