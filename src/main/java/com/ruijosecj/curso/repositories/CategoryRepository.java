package com.ruijosecj.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruijosecj.curso.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
