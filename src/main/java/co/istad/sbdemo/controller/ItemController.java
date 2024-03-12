package co.istad.sbdemo.controller;

import co.istad.sbdemo.model.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ItemController {

    private List<Item> items = new ArrayList<>();

    @GetMapping("/items")
    public String getAllItems(Model model) {
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
        items.add(item);
        return "redirect:/items";
    }

    @PostMapping("/{id}/delete")
    public String deleteItem(@PathVariable Long id) {
        items.removeIf(item -> item.getId().equals(id));
        return "redirect:/items";
    }

}

