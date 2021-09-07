package com.hemanth.mockito.test_doubles.withMockito;

import java.util.List;

public class ItemService {

    public ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void addNewItem(Items item){
        itemRepository.addItem(item);
    }

    public List<Items> getAllItems(){
        return itemRepository.getAllItems();
    }
}
