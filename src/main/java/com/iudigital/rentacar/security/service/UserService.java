package com.iudigital.rentacar.security.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.iudigital.rentacar.data.UserRepository;
import com.iudigital.rentacar.domain.User;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> optionalUser = userRepository.findByEmail(username);
		
		if (!optionalUser.isPresent()) { //if (optionalUser.isPresent() == false) {
			
			throw new UsernameNotFoundException("Usuario no existe");
			
		} else {
			
			User user = optionalUser.get();
			
			List<SimpleGrantedAuthority> roles = new ArrayList<>();
			
			roles.add(new SimpleGrantedAuthority(user.getRol().getId()));
			
			UserDetails userDetails = new org.springframework
					.security.core.userdetails.User(user.getEmail(), user.getPassword(), roles);
			
			return userDetails;
			
		}
		
	}

}
