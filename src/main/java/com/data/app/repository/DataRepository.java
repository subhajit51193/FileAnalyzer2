package com.data.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.data.app.entity.Data;

public interface DataRepository extends JpaRepository<Data, String>{

}
