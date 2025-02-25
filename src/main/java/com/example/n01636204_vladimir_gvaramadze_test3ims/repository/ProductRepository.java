package com.example.n01636204_vladimir_gvaramadze_test3ims.repository;

import com.example.n01636204_vladimir_gvaramadze_test3ims.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
}




