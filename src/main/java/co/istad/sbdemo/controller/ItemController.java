package co.istad.sbdemo.controller;

import co.istad.sbdemo.model.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import co.istad.sbdemo.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/items")
    public String getAllItems(Model model) {
        List<Item> items = itemService.getAllItems();
        model.addAttribute("items", items);
        return "items";
    }

    @GetMapping("/new")
    public String showNewItemForm(Model model) {
        model.addAttribute("item", new Item());
        return "new-item";
    }

    @PostMapping("/items")
    public String createNewItem(@ModelAttribute Item item) {
        itemService.createNewItem(item);
        return "redirect:/items";
    }

    @PostMapping("/{id}/delete")
    public String deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return "redirect:/items";
    }
}

