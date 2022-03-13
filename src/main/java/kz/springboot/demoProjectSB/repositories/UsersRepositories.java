package kz.springboot.demoProjectSB.repositories;

import kz.springboot.demoProjectSB.entities.UsersClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepositories extends JpaRepository<UsersClass, Long>
{

    UsersClass findbyEmail(String email);
}
