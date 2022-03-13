package kz.springboot.demoProjectSB.controllers;

import kz.springboot.demoProjectSB.beans.TestBean;
import kz.springboot.demoProjectSB.entities.Categories;
import kz.springboot.demoProjectSB.entities.Countries;
import kz.springboot.demoProjectSB.entities.ShopItem;
import kz.springboot.demoProjectSB.repositories.CAtegoryRepositories;
import kz.springboot.demoProjectSB.repositories.CountriesRepositories;
import kz.springboot.demoProjectSB.repositories.ShopItemRepositories;
import kz.springboot.demoProjectSB.service.ItemService;
import org.hibernate.cache.spi.CacheTransactionSynchronization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController
{
    @Autowired
    private ItemService itemService;

    @GetMapping(value = "index")
    public String index(Model model)
    {
        List<ShopItem> items = itemService.getAllItems();
        model.addAttribute("tovary", items);

        List<Countries> countries = itemService.getAllCountries();
        model.addAttribute("countries",countries);

        return "index";
    }


    @PostMapping(value = "addItem")
    public String addItem(@RequestParam(name = "country_id", defaultValue = "0")Long country_id,
                          @RequestParam(name = "ItemName", defaultValue = "no Item")String name,
                          @RequestParam(name = "ItemPrice", defaultValue = "0")int price,
                          @RequestParam(name = "ItemAmount", defaultValue = "0") int amount)
    {

        Countries cnt = itemService.getCountry(country_id);

        if(cnt != null)
        {
            ShopItem items = new ShopItem();
            items.setName(name);
            items.setPrice(price);
            items.setAmount(amount);
            items.setCountry(cnt);
            itemService.addItem(items);

        }
        return "redirect:index";
    }


    @GetMapping(value = "details/{idSS}")
    public String details(Model model, @PathVariable(name = "idSS")Long id)
    {
        ShopItem item = itemService.getItem(id);
        model.addAttribute("item", item);

        List<Countries> countries  = itemService.getAllCountries();
        model.addAttribute("countries", countries);

        List<Categories> categories = itemService.getAllCategories();
        model.addAttribute("categories",categories);



        return "details";
    }

    @PostMapping(value = "saveItem")
    public String saveItem(
            @RequestParam(name = "ItemID", defaultValue = "0")Long id,
            @RequestParam(name = "country_id", defaultValue = "0")Long country_id,
            @RequestParam(name = "ItemName", defaultValue = "no Item")String name,
            @RequestParam(name = "ItemPrice", defaultValue = "0")int price,
            @RequestParam(name = "ItemAmount", defaultValue = "0") int amount)
    {
        ShopItem item = itemService.getItem(country_id);
        if(item!=null) {
            Countries cnt = itemService.getCountry(id);

            if (cnt != null) {
                item.setName(name);
                item.setPrice(price);
                item.setAmount(amount);
                item.setCountry(cnt);
                itemService.saveItems(item);
            }
        }
        return "redirect:index";

    }

    @PostMapping(value = "/deleteItem")
    public String deleteItem(
            @RequestParam(name = "ItemID", defaultValue = "0")Long id)
    {
        ShopItem item = itemService.getItem(id);
        if(item!=null)
        {
            itemService.deleteItem(item);
        }
        return "redirect:index";
    }

    @Autowired
    private TestBean testBean;

    @GetMapping(value = "about")
    public String about()
    {
        return "about";
    }

    @PostMapping(value = "/assigncategory")
    public String assigncategory(@RequestParam(name = "item_id") Long ItemID,
                                 @RequestParam(name = "category_id") Long CategoryID)
    {
        Categories cat = itemService.getCategories(CategoryID);
        if(cat != null)
        {
            ShopItem item = itemService.getItem(ItemID);
            if(item!= null)
            {
                List<Categories> categories = item.getCategory();
                if(categories == null)
                {
                    categories = new ArrayList<>();
                }
                categories.add(cat);

                itemService.saveItems(item);

                return "redirect: /details/" + ItemID;
            }
        }
        return "redirect: index";

    }

    @GetMapping(value = "/403")
    public String accessDenided(Model model)
    {
        return "403";
    }


}
