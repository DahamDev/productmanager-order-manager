package com.productservice.ordermanager.external;

import com.productservice.ordermanager.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);

}
