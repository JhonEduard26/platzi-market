package com.platzi.market.domain.repository;

import com.platzi.market.domain.BuyDto;

import java.util.List;
import java.util.Optional;

public interface BuyRepositoryDto {
    List<BuyDto> getAll();
    Optional<List<BuyDto>> getByClient(String clientId);
    BuyDto save(BuyDto buyDto);
}
