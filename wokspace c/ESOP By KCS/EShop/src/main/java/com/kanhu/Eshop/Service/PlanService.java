package com.kanhu.Eshop.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.kanhu.Eshop.Entity.Plan;
import com.kanhu.Eshop.Repository.PlanRepository;

/**
 * @author kanhu cahran sahu
 *This calss   and get paln object by id ,year and active plan object
 */
@Service
public class PlanService {
	@Autowired
	private PlanRepository planRepository;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static final Logger LOGGER = LoggerFactory.getLogger(PlanService.class);
	/**
	 * @param plan 
	 * Save paln object in plan table by using paln repositoty save method
	 */
	public void savePlan(Plan plan) {
		planRepository.save(plan);
		LOGGER.info("Inside savePlan() of PlanService  plan{}: " + plan);
	}

	/**
	 * @param planYear
	 * @return list of paln object
	 * By using year getting a particular year howmany plan is there
	 */
	public List<Plan> findActivePlandByPlanYear(String planYear) {
		 List<Plan> byPlanYear = planRepository.getPlanByPlanYear(planYear);
		LOGGER.info("Inside findActivePlandByPlanYear() of PlanService  planYear{}: " + planYear+" "+byPlanYear);
		return  byPlanYear ;
	}

	/**
	 * @param id
	 * @return plan object
	 * by id get plan object
	 */
	public Plan findByPlanId(Long id) {
		
		 Plan plan = planRepository.getReferenceById(id);
		 LOGGER.info("Inside findByPlanId() of PlanService  id{}: " + id+" "+plan);
		 return plan;
	}

	/**
	 * @return list of plan object
	 * By using jdbc temple only actingplan object geting by sql query
	 */
	public Plan getCurrentActivePlan() {
		String querry = "select * from plan_info where is_current_plan=1;";
		List<Plan> list = jdbcTemplate.query(querry, new BeanPropertyRowMapper<Plan>(Plan.class));
		LOGGER.info("Inside getCurrentActivePlan() of PlanService list{}: " + list);
		return list.get(1);
	}
}
