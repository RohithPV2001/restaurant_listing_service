package com.example.restaurant.listing.mapper;

import org.mapstruct.Mapper;
//import org.mapstruct.factory.Mappers;

import com.example.restaurant.listing.models.Restuarant;
import com.example.restaurant.listing.dto.*;

@Mapper(componentModel = "spring")
public interface RestuarantMapper {
    
    //RestuarantMapper INSTANCE = Mappers.getMapper(RestuarantMapper.class); 

    Restuarant mapRestuarantDTOToRestuarant(RestuarantDTO restaurantDTO);
    RestuarantDTO mapRestuarantToRestuarantDTO(Restuarant restuarant);
}
