package kz.springboot.demoProjectSB.repositories;

import kz.springboot.demoProjectSB.entities.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface CAtegoryRepositories extends JpaRepository<Categories, Long>
{

}
