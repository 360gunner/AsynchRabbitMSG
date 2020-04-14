package com.gunner.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.gunner.demo.model.Test;


@RepositoryRestResource(collectionResourceRel = "Test", path = "test")
public interface testRepo extends JpaRepository<Test, Integer> {


}