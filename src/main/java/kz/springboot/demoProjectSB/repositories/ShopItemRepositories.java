package kz.springboot.demoProjectSB.repositories;

import groovy.transform.Trait;
import kz.springboot.demoProjectSB.entities.ShopItem;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ShopItemRepositories extends JpaRepository<ShopItem,Long>
{
    List<ShopItem> findAllByAmountGreaterThanOrderByPriceDesc(int amount);
    ShopItem findByIdAndAmountGreaterThan(Long id, int amount);
}
