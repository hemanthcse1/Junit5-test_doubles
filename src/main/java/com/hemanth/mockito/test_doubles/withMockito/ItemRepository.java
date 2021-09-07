package com.hemanth.mockito.test_doubles.withMockito;

import java.util.Collection;
import java.util.List;

public interface ItemRepository {

    void addItem(Items item);
    List<Items> getAllItems();
}
