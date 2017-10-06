/*
* This interface defines the methods used to perform CRUD operations on Users
* Author: Vatsal Vora
* Date: 8/31/2017
*/

package com.cookcollab.data.repo;

import com.cookcollab.data.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findByFirstName(String firstName);
    User findByUserID(long userID);
}
