package com.example.restaurant.listing.service;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.restaurant.listing.dto.RestuarantDTO;
import com.example.restaurant.listing.mapper.RestuarantMapper;
import com.example.restaurant.listing.repo.*;
import com.example.restaurant.listing.models.*;


@Service
public class RestuarantService {
    
    @Autowired
    RestuarantRepo restuarantRepo;

    @Autowired
    private RestuarantMapper mapper;

    public List<RestuarantDTO> findAllRestuarants(){
        List<Restuarant> restuarants = restuarantRepo.findAll();

        List<RestuarantDTO> restuarantDTOs = restuarants.stream().map(restuarant -> mapper.mapRestuarantToRestuarantDTO(restuarant)).collect(Collectors.toList());
        return restuarantDTOs;
    }


    public RestuarantDTO addRestuarantInDB(RestuarantDTO restuarantDTO){
        Restuarant savedRestuarant = restuarantRepo.save(mapper.mapRestuarantDTOToRestuarant(restuarantDTO));
        return mapper.mapRestuarantToRestuarantDTO(savedRestuarant);
    }

    public ResponseEntity<RestuarantDTO> findRestuarantById(int id){
        Optional<Restuarant> restuarant =  restuarantRepo.findById(id);
        if(restuarant.isPresent()){
            return new ResponseEntity<>(mapper.mapRestuarantToRestuarantDTO(restuarant.get()),HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
}
