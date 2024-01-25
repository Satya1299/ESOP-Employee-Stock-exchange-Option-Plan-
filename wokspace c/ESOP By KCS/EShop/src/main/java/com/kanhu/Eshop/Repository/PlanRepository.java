package com.kanhu.Eshop.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kanhu.Eshop.Entity.Plan;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {
	List<Plan> getPlanByPlanYear(String planYear);

}
