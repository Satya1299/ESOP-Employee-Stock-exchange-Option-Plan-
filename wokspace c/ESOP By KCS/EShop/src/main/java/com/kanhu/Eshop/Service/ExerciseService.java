package com.kanhu.Eshop.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.kanhu.Eshop.Dto.OptionDto;
import com.kanhu.Eshop.Entity.Allocation;
import com.kanhu.Eshop.Entity.Exercise;
import com.kanhu.Eshop.Entity.Grant;
import com.kanhu.Eshop.Entity.Plan;
import com.kanhu.Eshop.Repository.ExerciseReository;

/**
 * @author kanhu charan sahu
 * 
 * this service class implementing business logic for calculating updating and saving the exercise amount to save the database
 *
 */
@Service
public class ExerciseService {
	@Autowired
	private ExerciseReository exerciseReository;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private VestingOptionService vestingOptionService;
	private static final Logger LOGGER = LoggerFactory.getLogger(ExerciseService.class);

	/**
	 * @param exercise
	 * 
	 *                 This method filtering certain operations
	 *  1.from grand list find the plan id which getting the plan object(getting from
	 *    exercise grant id get grant object) in exercise table
	 *     grant_id property get the grant object 
	 *  2.By grant table plan_id get the plan object and filtering the vesting date
	 *   and vesting factor which is not null then get the plan object
	 *    then that plan list find the vesting factor which is required
	 *    for calculation of vesting option
	 * 3.Collecting the allocation object which is recently allocation approved by actual
	 *  allocation date for updating the vesting option for new
	 *   calculation formula.
	 * 4.Getting list of allocation object which have allocation status is approved filtering by java 8
	 *     features 
	 *5.Getting list of vesting dto which have sum  of  allocation by grnt_id 6.here to save and updating both
	 *   operation performing by DI of exercise repository save
	 *    method. 
	 * 6.for the here checking condition is that if allocation status approved and recent allocation sattus not mention
	 *    allocation not present the new exercise list save the date
	 *    base by new id otherwise if this id is available then adding
	 *   the fresh allocation amount multiple the vestingfactor and
	 *    adding the vestingoption which is present in the exerces tble
	 *    and updating it by exercise id.
	 * 
	 *
	 */
	public void saveExercise(Exercise exercise) {
		LOGGER.info("Inside saveExercise() of ExerciseService  exercise {}: " + exercise);
		List<Grant> grant = getObjectOfGrant(exercise.getGrantId());
		Grant grant2 = grant.stream().filter(e -> e.getPlanId().equals(exercise.getGrantId()))
				.collect(Collectors.toList()).get(0);
//		System.out.println(grant2);

		List<Plan> plan = getPaln(grant2.getPlanId());
		Plan plan2 = plan.stream().filter(e -> !e.getVestedDate().equals(null) && !e.getVestedDate().equals(null))
				.collect(Collectors.toList()).get(0);
		Double vestingFactor = plan2.getVestingFactor();
//		System.out.println(plan2);

		List<Allocation> actualDate = getRecentActualDate(exercise.getGrantId());
		Allocation allocation2 = actualDate.stream().collect(Collectors.toList()).get(0);
		Long numberOfAllocation = allocation2.getNumberOfAllocation();
//		System.out.println(actualDate);

		List<Allocation> allocation = getAllocationObject(exercise.getGrantId());
		List<Allocation> list = allocation.stream().filter(e -> e.getAllocationStatus().equals("Aprroved"))
				.collect(Collectors.toList());
//		System.out.println(list);

		List<OptionDto> listSumOption = getSumOfAllocion(exercise.getGrantId());
		OptionDto dto = listSumOption.stream().filter(e -> e.getGrantId().equals(exercise.getGrantId()))
				.collect(Collectors.toList()).get(0);
		Double sumOfAllocatedAllocation = dto.getSumOfAllocatedAllocation();
//		System.out.println(dto);

		if (!list.isEmpty() && !actualDate.isEmpty()) {
			exercise.setGrantId(exercise.getGrantId());
			exercise.setVestingOption((vestingFactor * sumOfAllocatedAllocation));
			updateExercise(exercise.getGrantId(), exercise);
		} else if (list.isEmpty()) {
			Exercise exercise2 = getExerciseByGrandId(exercise.getGrantId());
			Double total = exercise2.getVestingOption();
			exercise2.setVestingOption(total + (vestingFactor * numberOfAllocation));
			updateExercise(exercise2.getGrantId(), exercise2);
		}
	}

	/**
	 * @param grantId
	 * @return list of grant object By usingthis method getthe grant object list
	 *         from database
	 */
	private List<Grant> getObjectOfGrant(Long grantId) {

		String sql = "select * from garnt_info ;";
		List<Grant> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Grant>(Grant.class));
		LOGGER.info("Inside getObjectOfGrant() of ExerciseService  Id {}: " + grantId + " " + list);
		return list;

	}

	/**
	 * @param grantId
	 * @return list of option dto which is having sum of allocation
	 * 
	 *         By this method get the sum od allocation grouping by grant id which
	 *         is allocation approved
	 */
	private List<OptionDto> getSumOfAllocion(Long grantId) {
		List<OptionDto> sumOfAllocation = vestingOptionService.calculateSumOfAllocation();
		LOGGER.info("Inside saveVestingOption() of ExerciseService  grantId {}: " + grantId + " " + sumOfAllocation);
		return sumOfAllocation;

	}

	/**
	 * @param id
	 * @return list of plan object thought plan id using jdbcTemple forming sql
	 *         query find the records of plan
	 */
	private List<Plan> getPaln(Long id) {
		String sql = "select * from plan_info ;";
		List<Plan> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Plan>(Plan.class));
		LOGGER.info("Inside getPaln() of ExerciseService  Id {}: " + id + " " + list);
		return list;

	}

	/**
	 * @param grandId
	 * @return list of allocation By this method get the all allocation records from
	 *         database
	 */
	private List<Allocation> getAllocationObject(Long grandId) {
		String sql = "select * from allocaion_info ;";
		List<Allocation> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Allocation>(Allocation.class));
		LOGGER.info("Inside getAllocationObject() of ExerciseService  grandId {}: " + grandId + " " + list);
		return list;

	}

	/**
	 * @param GrandId
	 * @return exercise object by this method get the updated exercise data from
	 *         datatbse
	 */
	private Exercise getExerciseByGrandId(Long GrandId) {
		Exercise exercise = exerciseReository.getReferenceById(GrandId);
		LOGGER.info("Inside getExerciseByGrandId() of ExerciseService  Id {}: " + GrandId + " " + exercise);
		return exercise;

	}

	/**
	 * @param grantId
	 * @return list of allocation in this method find allocation list filtering the
	 *         allocation date which is recently added and grouping by garnd id
	 */
	private List<Allocation> getRecentActualDate(Long grantId) {
		String sql = "SELECT * FROM allocaion_info  WHERE actual_allocation_date=CURRENT_DATE GROUP BY  grant_id;";
		List<Allocation> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Allocation>(Allocation.class));
		LOGGER.info("Inside getRecentActualDate() of ExerciseService grantId {}: " + grantId + " " + list);
		return list;
	}

	/**
	 * @param id
	 * @param exercise update the exercise table vesting option column
	 */
	private void updateExercise(Long id, Exercise exercise) {
		exerciseReository.save(exercise);
		LOGGER.info("Inside updateExercise() of ExerciseService Id,exercise {}: " + id + " " + exercise);
	}

}
