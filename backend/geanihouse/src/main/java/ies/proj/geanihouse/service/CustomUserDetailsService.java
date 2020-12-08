package ies.proj.geanihouse.service;

import ies.proj.geanihouse.model.CustomUserDetails;
import ies.proj.geanihouse.model.User;
import ies.proj.geanihouse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.swing.plaf.synth.SynthTextAreaUI;


@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        System.out.println(user.getPassword());
        System.out.println(username);
        CustomUserDetails ud = null;
        if (user!=null){
            ud = new CustomUserDetails(user);
        }else{
            throw new UsernameNotFoundException("Username Not Found: "+ username);
        }
        System.out.println(ud.getPassword());
        return ud;
    }


}