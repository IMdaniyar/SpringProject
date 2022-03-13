package kz.springboot.demoProjectSB.repositories;

import kz.springboot.demoProjectSB.entities.Countries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CountriesRepositories extends JpaRepository<Countries, Long>
{

}
