package co.istad.sbdemo.service;

import co.istad.sbdemo.model.Item;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private List<Item> items = new ArrayList<>();
    private Integer nextItemId = 1;

    @Override
    public List<Item> getAllItems() {
        return items;
    }

    @Override
    public Item createNewItem(Item item) {
        item.setId(nextItemId++); // Set the ID and increment for the next item
        items.add(item);
        return item;
    }

    @Override
    public void deleteItem(Long id) {
        items.removeIf(item -> item.getId().equals(id));
    }
}

