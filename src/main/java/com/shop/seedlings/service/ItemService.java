package com.shop.seedlings.service;

import com.shop.seedlings.domain.entity.Item;
import com.shop.seedlings.domain.entity.Subtype;
import com.shop.seedlings.domain.entity.Type;

import java.util.List;

public interface ItemService {
    Item getItemById(int id);
    List<Item> getAllItems();
    void saveItem(Item item);
    void deleteItem(int id);
    List<Item> getAllDiscountItems();

    List<Type> getAllTypes();
    List<Subtype> getAllSubtypes(int typeId);
    List<Subtype> getSubtypes();

    List<Item> getAllSubtypeItems(int subtypeId);
    List<Item> getAllTypeItems(int typeId);

    Type getTypeById(int id);
    Subtype getSubtypeById(int id);
}
