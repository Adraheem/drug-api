package com.raheem.drugstore.controllers;

import com.raheem.drugstore.dtos.CreateDrugRequestDto;
import com.raheem.drugstore.dtos.DrugDto;
import com.raheem.drugstore.dtos.PageDto;
import com.raheem.drugstore.services.DrugService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/drug")
@AllArgsConstructor
public class DrugController {

    private final DrugService drugService;

    @PostMapping
    public ResponseEntity<DrugDto> createDrug(@Valid @RequestBody CreateDrugRequestDto requestDto) {
        return ResponseEntity.ok(drugService.createDrug(requestDto));
    }

    @GetMapping
    public ResponseEntity<PageDto<DrugDto>> getAllDrugs() {
        return ResponseEntity.ok(drugService.getAllDrugs(Pageable.ofSize(20)));
    }
}
