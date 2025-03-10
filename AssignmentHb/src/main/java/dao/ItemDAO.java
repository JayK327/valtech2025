package dao;

import java.util.List;
import entity.Item;

public interface ItemDAO {

    void save(Item item);

    Item get(long id);

    void update(Item item);

    void delete(long id);

    List<Item> getAll();
}

