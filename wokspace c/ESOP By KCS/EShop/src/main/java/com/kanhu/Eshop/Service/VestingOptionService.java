package com.kanhu.Eshop.Service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.kanhu.Eshop.Dto.OptionDto;
import com.kanhu.Eshop.Dto.VestingOptionDto;
import com.kanhu.Eshop.Entity.Plan;
import com.kanhu.Eshop.Repository.PlanRepository;

/**
 * @author kanhu charan sahu
 *This class having update paln table and by sql query calucating sumofno of allocation from 3 table
 * which is in proprty of vestingoption dto calss
 */
@Service
public class VestingOptionService {
	@Autowired 
	private PlanRepository planRepository;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static final Logger LOGGER = LoggerFactory.getLogger(VestingOptionService.class);

	/**
	 * @param dto
	 * In this method upading vestin date nd vestingfactor by using palnrepository save method
	 */
	public void updatePlanByVestingDto(VestingOptionDto dto) {
		Plan plan = getpaln(dto.getPlanId());
//		System.out.println(plan);
		plan.setVestedDate(new Date());
		plan.setVestingFactor(dto.getVestingFactor());
		planRepository.save(plan);
		LOGGER.info("Inside updatePlanByVestingDto() of VestingOptionService  dto{}: " +dto);

	}

	/**
	 * @param id
	 * @return list of plan
	 * By using this sql query get upated plan object
	 */
	private Plan getpaln(Long id) {
		String sql = "select * from plan_info ;";
		List<Plan> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Plan>(Plan.class));
//		System.out.println(list);
		LOGGER.info("Inside getpaln() of VestingOptionService  id{}: " + id+" "+list);
		return list.get(1);
	}

	/**
	 * @return list of vesting dto object
	 * By using jdbc temple and using sql join concept from three table sum of alloction by grant id of given plan 
	 */
	public List<OptionDto> calculateSumOfAllocation() {
		String query = "SELECT garnt_info.plan_id,garnt_info.id AS grantId,SUM(allocaion_info.number_of_allocation) AS sumOfAllocatedAllocation\r\n"
				+ "FROM  garnt_info \r\n" + "LEFT JOIN allocaion_info ON garnt_info.id=allocaion_info.grant_id\r\n"
				+ "WHERE allocaion_info.allocation_status=\"Approved\"\r\n" + "GROUP BY allocaion_info.grant_id;";
		List<OptionDto> list = jdbcTemplate.query(query, new BeanPropertyRowMapper<OptionDto>(OptionDto.class));
//		list.forEach(n -> System.out.println(n));
		LOGGER.info("Inside calculateSumOfAllocation() of VestingOptionService  list{}: " + list);
		return list;
	}
}
