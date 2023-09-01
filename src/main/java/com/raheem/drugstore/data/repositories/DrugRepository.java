package com.raheem.drugstore.data.repositories;

import com.raheem.drugstore.data.models.Drug;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugRepository extends JpaRepository<Drug, Long> {
}
