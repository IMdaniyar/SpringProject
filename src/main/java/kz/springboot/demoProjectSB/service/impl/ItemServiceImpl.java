package kz.springboot.demoProjectSB.service.impl;

import kz.springboot.demoProjectSB.entities.Categories;
import kz.springboot.demoProjectSB.entities.Countries;
import kz.springboot.demoProjectSB.entities.ShopItem;
import kz.springboot.demoProjectSB.repositories.CAtegoryRepositories;
import kz.springboot.demoProjectSB.repositories.CountriesRepositories;
import kz.springboot.demoProjectSB.repositories.ShopItemRepositories;
import kz.springboot.demoProjectSB.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService
{

    @Autowired
    private ShopItemRepositories shopItemRepositories;

    @Autowired
    CountriesRepositories countriesRepositories;

    @Autowired
    CAtegoryRepositories cAtegoryRepositories;

    @Override
    public ShopItem addItem(ShopItem item) {
        return shopItemRepositories.save(item);
    }

    @Override
    public List<ShopItem> getAllItems() {
        return shopItemRepositories.findAllByAmountGreaterThanOrderByPriceDesc(0);
    }

    @Override
    public ShopItem getItem(Long id) {
        return shopItemRepositories.findByIdAndAmountGreaterThan(id, 0);
    }

    @Override
    public void deleteItem(ShopItem item) {
        shopItemRepositories.delete(item);
    }

    @Override
    public ShopItem saveItems(ShopItem item) {
        return shopItemRepositories.save(item);
    }

    @Override
    public List<Countries> getAllCountries() {
        return countriesRepositories.findAll();
    }

    @Override
    public Countries addCountry(Countries country) {
        return  countriesRepositories.save(country);
    }

    @Override
    public Countries saveCountry(Countries country) {
        return countriesRepositories.save(country);
    }

    @Override
    public Countries getCountry(Long id) {
        return countriesRepositories.getOne(id);
    }


    @Override
    public List<Categories> getAllCategories() {
        return cAtegoryRepositories.findAll();
    }

    @Override
    public Categories getCategories(long id) {
        return cAtegoryRepositories.getOne(id);
    }

    @Override
    public Categories addCategories(Categories categories) {
        return cAtegoryRepositories.save(categories);
    }

    @Override
    public Categories saveCategories(Categories categories) {
        return cAtegoryRepositories.save(categories);
    }
}
