package com.kanhu.Eshop.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kanhu.Eshop.Constant.EsopConstant;
import com.kanhu.Eshop.Entity.Plan;
import com.kanhu.Eshop.Service.PlanService;

/**
 * @author kanhu charan sahu This class plan controller save and get the plan
 *         required of client database by DI of plan service
 */
@RestController
@RequestMapping(value = EsopConstant.FORWORDSLASH)
public class PlanController {
	@Autowired
	private PlanService planService;
	private static final Logger LOGGER = LoggerFactory.getLogger(PlanController.class);

	/**
	 * @param plan this method save the plan object to the database through the plan
	 *             object
	 */
	@PostMapping(value = EsopConstant.SAVE_PLAN)
	public void subScribePlan(@RequestBody Plan plan) {
		LOGGER.info("Inside subScribePlan() of PlanController  plan {}: " + plan);
		planService.savePlan(plan);
	}

	/**
	 * @param year
	 * @return plan object this method give list of plan filtering based he paln
	 *         year
	 */
	@GetMapping(value = EsopConstant.GET_ACTIVEPLAN_BY_PLAN_YEAR)
	public @ResponseBody List<Plan> getActivePlanByPlanYear(String year) {
		LOGGER.info("Inside getActivePlanByPlanYear() of PlanController  year {}: " + year);
		return planService.findActivePlandByPlanYear(year);
	}
}
