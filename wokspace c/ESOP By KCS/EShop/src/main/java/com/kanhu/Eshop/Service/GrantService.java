package com.kanhu.Eshop.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.kanhu.Eshop.Dto.GrantDto;
import com.kanhu.Eshop.Entity.Allocation;
import com.kanhu.Eshop.Entity.Grant;
import com.kanhu.Eshop.Entity.Plan;
import com.kanhu.Eshop.Repository.AllocationRepository;
import com.kanhu.Eshop.Repository.GrantRepository;

/**
 * @author kanhu charan sahu
 *This class having save ,update and  allcating grant and save allocation and process allocation and scheduing the allocation 
 *by DIS of grant repositort jdbc temple ,plan service and allocation Repository
 */
@EnableScheduling
@Service
public class GrantService {

	@Autowired
	private GrantRepository grantRepository;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private PlanService planService;
	@Autowired
	private AllocationRepository allocationRepository;
	private static final Logger LOGGER = LoggerFactory.getLogger(GrantService.class);

	/**
	 * @param grantDto
	 * @return list of garnt
	 * By using garnt dto propery save all grant proper in grant table and each grant add to grant list
	 */
	private List<Grant> processGrant(List<GrantDto> grantDto) {
		List<Grant> grantlist = new ArrayList<Grant>();
		LOGGER.info("Inside processGrant() of GrantService  grantDto{}: " + grantDto);
		for (GrantDto grantDto2 : grantDto) {
			Grant grant = new Grant();
			grant.setEmployeeNumber(grantDto2.getEmployeeNumber());
			grant.setBand(grantDto2.getBand());
			grant.setNumberOfGrants(grantDto2.getNumberOfGrants());
			grant.setGrantPrice(grantDto2.getGrantPrice());
			grant.setLockInStatus(grantDto2.getLockInStatus());
			grant.setFrequency(grantDto2.getFrequency());
			grant.setVestingTenure(grantDto2.getVestingTenure());
			grant.setGrantStatus("Open");
			grant.setAllocationStatus("open");
			grant.setAccepted(true);
			grant.setAcceptedDate(new Date());
			grant.setPlanId(grantDto2.getPlanId());
			grantlist.add(grant);
		}
		for (Grant grant : grantlist) {
			System.out.println(grant);
		}
		return grantlist;
	}

	/**
	 * @param grantDtos
	 * By calling process grant save list of grant object in grant table by grant repository saveAll method
	 */
	public void saveGrand(List<GrantDto> grantDtos) {
		List<Grant> processGrant = processGrant(grantDtos);
		grantRepository.saveAll(processGrant);
		LOGGER.info("Inside saveGrand() of GrantService grantDtos {}: " + grantDtos);
	}

	/**
	 * @param id
	 * By id upading the garnt status approved by using jdbc temple update method
	 */
	private void findById(Long id) {
		String query = "update garnt_info set grant_status='Approved'   where id=?";
		jdbcTemplate.update(query, id);
		LOGGER.info("Inside findById() of GrantService  id {}: " + id);
	}

	/**
	 * @param grantIdList
	 * approving grant by calling find by id method
	 */
	public void approveGrants(List<Long> grantIdList) {
		for (Long long1 : grantIdList) {
			findById(long1);
			LOGGER.info("Inside approveGrants() of GrantService  long1 {}: " + long1);
		}
	}

	/**
	 * @param grantList
	 * updating grant list allocationstatus by usingjdbc temple class updatemethod
	 */
	private void updateGrants(List<Grant> grantList) {

		String sql = "update garnt_info set allocation_status='Approved' where grant_status='Approved' ";
		jdbcTemplate.update(sql);
		LOGGER.info("Inside updateGrants() of GrantService grantList {}: " + grantList);
	}

	/**
	 * @param planId
	 * @return list of grant
	 * By using this method get list of grant by filtering which have allocation status open and grant statusapproved by plan id
	 * by help of jdbc temple of springframe work
	 */
	public List<Grant> getGrantsForAllocationByPlanId(Long planId) {
		String sql = "select * from garnt_info where  allocation_status='open' and grant_status='Approved'; ";
	List<Grant> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Grant>(Grant.class));
	LOGGER.info("Inside getGrantsForAllocationByPlanId() of GrantService  planId {}: " + planId+" "+list);
		 return list;
	}

	/**
	 * @param grant
	 * @return list
	 * 
	 * this method preapring allocation for certain formula
	 * 1.if grant allocation status open and grant staus approved then 
	 * it if frequency is grater ttahn 0 then noof grant dived by frequency and allocating next five yaer
	 * each year noof allocation save 
	 * allocation status of allocation table pending and allocation year start from nextyaer and allocation date start from next yaer of same date
	 * 2.if frequency is zero then go to garnt band if grant band less then 6 no of grants divided by 5 and allocating next five year
	 * so here implemting forloop for next five year
	 * 3.if band graterthan 6 then no of grants divided by one and allocationg only next yaer.
	 * After that each alloction add the allocation list 
	 * 
	 * here for year taking string datatype and for next year using calender of java api and next year date using localdate of java
	 */
	private void properAllocation(Grant grant, List<Allocation> list) {
		Calendar cal = Calendar.getInstance();
		int count = 1;
		LOGGER.info("Inside properAllocation() of GrantService grant ,list {}: " + grant+" "+list);
		if (grant.getFrequency() > 0) {
			for (int i = 1; i <= 5; i++) {
				Allocation allocation = new Allocation();
				allocation.setAllocationStatus("Pending");
				allocation.setGrantId(grant.getId());
				allocation.setActualAllocationDate(null);
				allocation.setNumberOfAllocation(grant.getNumberOfGrants() / grant.getFrequency());
				allocation.setAlocationYear("" + (cal.get(Calendar.YEAR) + i));
				allocation.setPlannedAllocaionDate(LocalDate.now().plusYears(1));
				list.add(allocation);

				count++;
			}
			System.out.println(list);
		} else {

			if (grant.getBand() >= 6) {
				Allocation allocation = new Allocation();
				allocation.setAllocationStatus("Pending");
				allocation.setGrantId(grant.getId());
				allocation.setActualAllocationDate(null);
				allocation.setNumberOfAllocation(grant.getNumberOfGrants() / 1);
				allocation.setAlocationYear("" + (cal.get(Calendar.YEAR) + 1));
				allocation.setPlannedAllocaionDate(LocalDate.now().plusYears(1));
				list.add(allocation);
				count++;

			} else {
				for (int i = 1; i <= 5; i++) {
					Allocation allocation = new Allocation();
					allocation.setAllocationStatus("Pending");
					allocation.setGrantId(grant.getId());
					allocation.setActualAllocationDate(null);
					allocation.setNumberOfAllocation(grant.getNumberOfGrants() / 5);
					allocation.setAlocationYear("" + (cal.get(Calendar.YEAR) + i));
					allocation.setPlannedAllocaionDate(LocalDate.now().plusYears(1));
					list.add(allocation);
					count++;
					System.out.println(count++);
				}
			}
		}
	}

	/**
	 * In this method we call the prepare allocation method which give the list of allocation which approved grant staus
	 * and save the allocation table by allocation repsoitory save method
	 * here i call the getactivepaln which give plan object
	 * and getgantforalloction method by palnid give grantobject 
	 * each grant object by calling preaperallocation method allocating the grant
	 * 
	 */
	public void prepareAndProcessAllocation() {
		Plan plan = planService.getCurrentActivePlan();
		List<Grant> list = getGrantsForAllocationByPlanId(plan.getId());
		
		for (Grant grant : list) {
			List<Allocation> allcocation = new ArrayList<>();
			properAllocation(grant, allcocation);
			allocationRepository.saveAll(allcocation);
			updateGrants(list);
			LOGGER.info("Inside prepareAndProcessAllocation() of GrantService  grant,allcocation {}: " + grant+" "+ allcocation);
		}

	}

	/**
	 * @scheduler is annotaion of spring framework which have cron expression to schedulling every given time
	 * in this method call the prepareAllocation by creating new thewd which is independently doingttheir work
	 */
	@Scheduled(cron = "0 */20 * ? * *")
	public void init() {
		new Runnable() {

			@Override
			public void run() {
				System.out.println("running...");
				prepareAndProcessAllocation();
				LOGGER.info("Inside init() of GrantService  schedulling every 20 min {}: "  );
			}
		}.run();
	}

	/**
	 * @param id
	 * By Using Jdbctemple updating grant locking status after 
	 * calculating the exercise vestingoption and allocating required year
	 */
	public void updateLock(Long id) {
		String locking = "update garnt_info set lock_in_status=\"locked\"  WHERE id=?;";
		 jdbcTemplate.update(locking, id);
		LOGGER.info("Inside saveExercise() of GrantService  id {}: " + id);
	}
}
