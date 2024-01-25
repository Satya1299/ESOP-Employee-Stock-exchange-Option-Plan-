package com.kanhu.Eshop.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kanhu.Eshop.Entity.Grant;

@Repository 
public interface GrantRepository extends JpaRepository<Grant, Long> {

	List<Grant> getGrantsForAllocationByPlanId(Long planId);
//	 void updategrants(String )
}
