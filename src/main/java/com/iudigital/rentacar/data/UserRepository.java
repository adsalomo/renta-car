package com.iudigital.rentacar.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iudigital.rentacar.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
