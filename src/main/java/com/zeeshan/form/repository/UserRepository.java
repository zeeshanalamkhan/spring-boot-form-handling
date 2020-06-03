package com.zeeshan.form.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zeeshan.form.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
