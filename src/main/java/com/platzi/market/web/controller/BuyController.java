package com.platzi.market.web.controller;

import com.platzi.market.domain.BuyDto;
import com.platzi.market.domain.service.BuyServiceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Predicate;

@RestController
@RequestMapping("/buys")
public class BuyController {

    @Autowired
    private BuyServiceDto buyServiceDto;

    @GetMapping("/all")
    public ResponseEntity<List<BuyDto>> getAll(){
        return new ResponseEntity<>(buyServiceDto.getAll(), HttpStatus.OK);
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<List<BuyDto>> getByClient(@PathVariable("id") String clientId) {
        return buyServiceDto.getByClient(clientId)
                .filter(Predicate.not(List::isEmpty))
                .map(buysDto -> new ResponseEntity<>(buysDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<BuyDto> save(@RequestBody BuyDto buyDto) {
        return new ResponseEntity<>(buyServiceDto.save(buyDto), HttpStatus.CREATED);
    }

}
