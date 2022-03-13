package kz.springboot.demoProjectSB.service;

import kz.springboot.demoProjectSB.entities.Categories;
import kz.springboot.demoProjectSB.entities.Countries;
import kz.springboot.demoProjectSB.entities.ShopItem;
import kz.springboot.demoProjectSB.repositories.CAtegoryRepositories;

import java.util.List;

public interface ItemService
{
    ShopItem addItem(ShopItem item);
    List<ShopItem> getAllItems();
    ShopItem getItem(Long id);
    void deleteItem(ShopItem item);
    ShopItem saveItems(ShopItem item);


    List<Countries> getAllCountries();
    Countries addCountry(Countries country);
    Countries saveCountry(Countries country);
    Countries getCountry(Long id);

    List<Categories> getAllCategories();
    Categories getCategories(long id);
    Categories addCategories(Categories categories);
    Categories saveCategories(Categories categories);



}
