package com.ruijosecj.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruijosecj.curso.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
