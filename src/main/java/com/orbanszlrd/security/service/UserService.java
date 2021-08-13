package com.orbanszlrd.security.service;

import com.orbanszlrd.security.model.AppUserDetails;
import com.orbanszlrd.security.model.User;
import com.orbanszlrd.security.repository.UserRepository;
import com.orbanszlrd.security.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    private final JwtUtil jwtUtil;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByUsername(username);


        UserDetails userDetails = userOptional.map(AppUserDetails::new).get();
        String token = jwtUtil.generateToken(userOptional.map(AppUserDetails::new).get());

        log.info(token);
        log.info(jwtUtil.extractUsername(token));
        log.info(jwtUtil.extractExpiration(token));
        log.info(jwtUtil.validateToken(token, userDetails));

        return userOptional.map(AppUserDetails::new).orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
