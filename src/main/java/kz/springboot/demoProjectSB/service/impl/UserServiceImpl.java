package kz.springboot.demoProjectSB.service.impl;

import kz.springboot.demoProjectSB.entities.UsersClass;
import kz.springboot.demoProjectSB.repositories.UsersRepositories;
import kz.springboot.demoProjectSB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UsersRepositories usersRepositories;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersClass myUser = usersRepositories.findbyEmail(username);
        if(myUser != null)
        {
            User securityUser = new User(myUser.getEmail(), myUser.getPassword(), myUser.getRolesUsers());

            return securityUser;
        }

        throw new UsernameNotFoundException("User not Found!");
    }
}
