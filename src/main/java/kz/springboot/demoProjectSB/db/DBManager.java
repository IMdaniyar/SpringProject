package kz.springboot.demoProjectSB.db;

import java.util.ArrayList;

public class DBManager
{
    private static ArrayList<Items> items = new ArrayList<>();

    static
    {
        items.add(new Items(1L, "whey gold standard",10000));
        items.add(new Items(2L, "mass gainer",15000));
        items.add(new Items(3L, "creatine monohydrate",4000));
    }
    private static Long id = 5L;

    public static ArrayList<Items> getItems()
    {
        return items;
    }
    public static void AddItem(Items item)
    {
        item.setId(id);
        items.add(item);
        id++;
    }

    public static Items getItemsbyID(Long id)
    {
        for(Items it:items)
        {
            if(it.getId() == id)
            {
                return it;
            }
        }
        return null;
    }
}
