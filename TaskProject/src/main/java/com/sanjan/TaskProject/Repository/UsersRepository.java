package com.sanjan.TaskProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sanjan.TaskProject.Entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{

}
