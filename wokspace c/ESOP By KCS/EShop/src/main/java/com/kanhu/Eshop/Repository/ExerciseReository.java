package com.kanhu.Eshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kanhu.Eshop.Entity.Exercise;

@Repository
public interface ExerciseReository extends JpaRepository<Exercise, Long> {

}
