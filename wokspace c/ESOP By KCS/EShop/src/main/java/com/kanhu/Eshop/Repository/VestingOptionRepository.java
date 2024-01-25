package com.kanhu.Eshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kanhu.Eshop.Entity.VestingOption;

@Repository
public interface VestingOptionRepository extends JpaRepository<VestingOption, Long> {

}
