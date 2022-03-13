package kz.springboot.demoProjectSB.repositories;

import kz.springboot.demoProjectSB.entities.UsersRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RoleRepositories extends JpaRepository<UsersRole, Long>
{

}
