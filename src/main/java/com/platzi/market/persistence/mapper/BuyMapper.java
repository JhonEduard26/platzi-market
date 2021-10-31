package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.BuyDto;
import com.platzi.market.persistence.entity.Buy;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BuyProductDtoMapper.class})
public interface BuyMapper {

    @Mappings({
            @Mapping(source = "idBuy", target = "buyId"),
            @Mapping(source = "idClient", target = "clientId"),
            @Mapping(source = "products", target = "items"),
    })
    BuyDto toBuyDto(Buy buy);
    List<BuyDto> toBuys(List<Buy> buys);

    @InheritInverseConfiguration
    @Mapping(target = "client", ignore = true)
    Buy toBuy(BuyDto buyDto);
}
