package com.raheem.drugstore.dtos;

import com.raheem.drugstore.data.models.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DrugDto {

    private Long id;

    private String name;

    private String brand;

    private Status status;

    private LocalDateTime createdAt;
}
