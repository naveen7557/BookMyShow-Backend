/*package com.naveen.bookmyshow.services;

import com.naveen.bookmyshow.DAO.UserRepository;
import com.naveen.bookmyshow.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email);
        if(user==null) throw new UsernameNotFoundException("user not found");
        return user;
    }

    @Transactional
    public User loadUserById(Long id)
    {
        User user = userRepository.getById(id);
        if(user==null) throw new UsernameNotFoundException("user not found");
        return user;
    }
}*/
