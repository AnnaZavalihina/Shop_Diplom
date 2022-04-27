package tms.shchayuk.audition.dao;

import tms.shchayuk.audition.entity.Item;

import java.util.List;

public interface ItemDao {
    Item getItemById(int id);
    List<Item> getAllItems();
    void saveItem(Item item);
    void deleteItem(int id);
}
