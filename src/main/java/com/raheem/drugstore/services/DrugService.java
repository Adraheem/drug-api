package com.raheem.drugstore.services;

import com.raheem.drugstore.dtos.CreateDrugRequestDto;
import com.raheem.drugstore.dtos.DrugDto;
import com.raheem.drugstore.dtos.PageDto;
import org.springframework.data.domain.Pageable;

public interface DrugService {

    DrugDto createDrug(CreateDrugRequestDto requestDto);

    PageDto<DrugDto> getAllDrugs(Pageable pageable);

}
