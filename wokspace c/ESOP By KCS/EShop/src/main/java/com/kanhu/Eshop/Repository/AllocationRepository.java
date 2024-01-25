package com.kanhu.Eshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kanhu.Eshop.Entity.Allocation;

@Repository
public interface AllocationRepository extends JpaRepository<Allocation, Long> {

	Allocation findAllocationByGrantId(Long grantId);
}
