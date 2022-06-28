package com.shop.seedlings.dao;

import com.shop.seedlings.domain.entity.Item;
import com.shop.seedlings.domain.entity.Subtype;
import com.shop.seedlings.domain.entity.Type;

import java.util.List;

public interface ItemDao {
    Item getItemById(int id);

    List<Item> getAllItems();

    List<Item> getAllSubtypeItems(int subtypeId);

    List<Item> getAllTypeItems(int typeId);

    void saveItem(Item item);

    List<Item> getAllDiscountItems();

    List<Type> getAllTypes();

    List<Subtype> getAllSubtypes(int typeId);

    Type getTypeById(int id);

    Subtype getSubtypeById(int id);
}
