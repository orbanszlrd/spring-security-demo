package com.orbanszlrd.security.service;

import com.orbanszlrd.security.model.AppUser;
import com.orbanszlrd.security.model.User;
import com.orbanszlrd.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isEmpty()) throw new UsernameNotFoundException(username);
        AppUser appUser = new AppUser(userOptional.get());

        return appUser;
    }
}
