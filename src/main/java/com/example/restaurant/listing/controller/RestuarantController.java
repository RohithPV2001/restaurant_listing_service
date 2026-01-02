package com.example.restaurant.listing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.example.restaurant.listing.dto.*;
import org.springframework.http.*;

import com.example.restaurant.listing.service.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/restuarant")
public class RestuarantController {
    
    @Autowired
    RestuarantService  restuarantService;

    @GetMapping("")
    public ResponseEntity<List<RestuarantDTO>> fetchAllRestuarants(){
        List<RestuarantDTO> allRestuarants = restuarantService.findAllRestuarants();
        return new ResponseEntity<>(allRestuarants,HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<RestuarantDTO> saveRestuarant(@RequestBody RestuarantDTO restuarantDTO){
        RestuarantDTO restuarantAdded = restuarantService.addRestuarantInDB(restuarantDTO);
        return new ResponseEntity<>(restuarantAdded,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestuarantDTO> findRestuarantById(@PathVariable int id){
        return restuarantService.findRestuarantById(id);
    }
}
