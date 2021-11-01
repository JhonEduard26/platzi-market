package com.platzi.market.domain.service;

import com.platzi.market.domain.BuyDto;
import com.platzi.market.domain.repository.BuyRepositoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuyServiceDto {

    @Autowired
    private BuyRepositoryDto buyRepositoryDto;

    public List<BuyDto> getAll() {
        return buyRepositoryDto.getAll();
    }

    public Optional<List<BuyDto>> getByClient(String clientId){
        return buyRepositoryDto.getByClient(clientId);
    }

    public BuyDto save(BuyDto buyDto){
        return buyRepositoryDto.save(buyDto);
    }
}
