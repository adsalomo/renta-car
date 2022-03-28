package com.iudigital.rentacar.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.iudigital.rentacar.data.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		com.iudigital.rentacar.domain.User user = userRepository
				.findByEmail(username).orElse(null);
		
		if (user == null) {
			throw new UsernameNotFoundException("usuario.no.existe");
		}
		
		List<SimpleGrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority(user.getRole().getName()));
		
		UserDetails userDetails = new User(user.getEmail(), user.getPassword(), roles);
		
		return userDetails;
		
	}
	
}
