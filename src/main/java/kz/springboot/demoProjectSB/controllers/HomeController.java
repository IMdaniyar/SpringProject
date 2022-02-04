package kz.springboot.demoProjectSB.controllers;

import kz.springboot.demoProjectSB.db.DBManager;
import kz.springboot.demoProjectSB.db.Items;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class HomeController
{
    @GetMapping(value = "index")
    public String index(Model model)
    {
        ArrayList<Items> items = DBManager.getItems();
        model.addAttribute("tovary", items);
        return "index";
    }
    @GetMapping(value = "about")
    public String about()
    {
        return "about";
    }

    @PostMapping(value = "addItem")
    public String addItem(@RequestParam(name = "ItemName", defaultValue = "no Item")String name,
                          @RequestParam(name = "ItemPrice", defaultValue = "0")int price)
    {
        DBManager.AddItem(new Items(null, name, price));
        return "redirect:index";
    }
    @GetMapping(value = "details")
    public String details(Model model, @RequestParam(name = "id")Long id)
    {
        Items items = DBManager.getItemsbyID(id);
        model.addAttribute("item", items);
        return "details";

    }
}
