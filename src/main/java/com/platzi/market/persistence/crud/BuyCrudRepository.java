package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.Buy;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BuyCrudRepository extends CrudRepository<Buy, Long> {

    Optional<List<Buy>> findByIdClient(String idClient);
}
