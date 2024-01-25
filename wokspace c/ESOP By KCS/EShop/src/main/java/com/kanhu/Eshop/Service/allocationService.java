package com.kanhu.Eshop.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @author kanhu charan sahu This is the logic of allocation which process and
 *         update by DI of jdbcTemple of spring framework
 */
@Service
public class allocationService {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static final Logger LOGGER = LoggerFactory.getLogger(allocationService.class);

	/**
	 * @param Id in this method updating the actual allocation date and allocation
	 *           status of grant table by garnt id
	 */
	public void getById(Long Id) {
		String query = "update allocaion_info set  actual_allocation_date=CURRENT_DATE ,allocation_status='Approved'  where id=?;";
		jdbcTemplate.update(query, Id);
		LOGGER.info("Inside saveVestingOption() of allocationService  Id {}: " + Id);
	}

	/**
	 * @param allocationId in this method approved list of grant by the grant id
	 *                     here calculating single grand by using for each method
	 *                     and each grant id approving allocation of grant
	 */
	public void approveAllocation(List<Long> allocationId) {
		for (Long long1 : allocationId) {
			LOGGER.info("Inside saveVestingOption() of allocationService  long1 {}: " + long1);
			getById(long1);
		}
	}
}
