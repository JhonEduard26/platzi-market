package com.platzi.market.persistence;

import com.platzi.market.domain.BuyDto;
import com.platzi.market.domain.repository.BuyRepositoryDto;
import com.platzi.market.persistence.crud.BuyCrudRepository;
import com.platzi.market.persistence.entity.Buy;
import com.platzi.market.persistence.mapper.BuyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BuyRepository implements BuyRepositoryDto {

    @Autowired
    private BuyCrudRepository buyCrudRepository;

    @Autowired
    private BuyMapper mapper;

    @Override
    public List<BuyDto> getAll() {
        return mapper.toBuys((List<Buy>) buyCrudRepository.findAll());
    }

    @Override
    public Optional<List<BuyDto>> getByClient(String clientId) {
        return buyCrudRepository.findByIdClient(clientId)
                .map(buys -> mapper.toBuys(buys));
    }

    @Override
    public BuyDto save(BuyDto buyDto) {
        Buy buy = mapper.toBuy(buyDto);
        buy.getProducts().forEach(buyProduct -> buyProduct.setBuy(buy));
        return mapper.toBuyDto(buyCrudRepository.save(buy));
    }
}
