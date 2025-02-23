package com.example.ProjectSpringBoot.repositories;

import com.example.ProjectSpringBoot.models.MovieDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDetailRepository extends JpaRepository<MovieDetail, Long> {
}
