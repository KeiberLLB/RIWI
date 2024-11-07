package com.Meta_Keiber.SpringBoot.domian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Meta_Keiber.SpringBoot.domian.entities.Users;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer>{

}
