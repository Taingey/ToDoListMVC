package co.istad.sbdemo.service;

import co.istad.sbdemo.model.Item;
import java.util.List;

public interface ItemService {
    List<Item> getAllItems();
    Item createNewItem(Item item);
    void deleteItem(Long id);
}

