package com.raheem.drugstore.services.impl;

import com.raheem.drugstore.data.models.Drug;
import com.raheem.drugstore.data.repositories.DrugRepository;
import com.raheem.drugstore.dtos.CreateDrugRequestDto;
import com.raheem.drugstore.dtos.DrugDto;
import com.raheem.drugstore.dtos.PageDto;
import com.raheem.drugstore.services.DrugService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;

@Service
@AllArgsConstructor
public class DrugServiceImpl implements DrugService {

    private final DrugRepository drugRepository;
    private final ModelMapper modelMapper;

    @Override
    public DrugDto createDrug(CreateDrugRequestDto requestDto) {
        Drug drug = Drug.builder()
                .name(requestDto.getName())
                .brand(requestDto.getBrand())
                .status(requestDto.getStatus())
                .build();

        drugRepository.saveAndFlush(drug);
        return modelMapper.map(drug, DrugDto.class);
    }

    @Override
    public PageDto<DrugDto> getAllDrugs(Pageable pageable) {
        Page<Drug> drugs = drugRepository.findAll(pageable);

        Type pageDtoTypeToken = new TypeToken<PageDto<DrugDto>>() {
        }.getType();
        return modelMapper.map(drugs, pageDtoTypeToken);
    }
}
