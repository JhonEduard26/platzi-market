package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.BuyProductDto;
import com.platzi.market.persistence.entity.BuyProduct;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface BuyProductDtoMapper {

    @Mappings({
            @Mapping(source = "id.idProduct", target = "productId"),
            @Mapping(source = "status", target = "active"),
    })
    BuyProductDto toBuyProductDto(BuyProduct buyProduct);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "buy", ignore = true),
            @Mapping(target = "product", ignore = true),
            @Mapping(target = "id.idBuy", ignore = true),
    })
    BuyProduct toBuyProduct(BuyProductDto buyProductDto);
}
