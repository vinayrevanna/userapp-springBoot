package vina.learnjava.userapp.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import vina.learnjava.userapp.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{}