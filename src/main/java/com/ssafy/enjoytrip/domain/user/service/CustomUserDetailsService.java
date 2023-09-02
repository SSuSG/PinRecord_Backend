package com.ssafy.enjoytrip.domain.user.service;


import com.ssafy.enjoytrip.domain.user.entity.User;
import com.ssafy.enjoytrip.domain.user.entity.UserDetailsImpl;
import com.ssafy.enjoytrip.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        log.info("UserDetailService_loadUserByUsername");
        User findUser = userRepository.findUserByLoginId(loginId);
        UserDetailsImpl userDetails = new UserDetailsImpl(findUser);
        return  userDetails;
    }
}
