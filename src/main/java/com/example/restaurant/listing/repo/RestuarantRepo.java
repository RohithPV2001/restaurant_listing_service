package com.example.restaurant.listing.repo;

import org.springframework.stereotype.Repository;

import com.example.restaurant.listing.models.*;

import org.springframework.data.jpa.repository.*;


@Repository
public interface RestuarantRepo extends JpaRepository<Restuarant,Integer>{
    
}
