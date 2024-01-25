package com.kanhu.Eshop.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kanhu.Eshop.Constant.EsopConstant;
import com.kanhu.Eshop.Service.allocationService;

/**
 * @author Kanhu charan sahu :-This class, controller the allocation of grant by
 *         Required DI of allocation services
 */
@RestController
@RequestMapping(value = EsopConstant.FORWORDSLASH)
public class AllocationController {

	@Autowired
	private allocationService allocationService;
	private static final Logger LOGGER = LoggerFactory.getLogger(AllocationController.class);

	/**
	 * @param ListOFallocationId this method approving allocation of grand which is
	 *                           approved after verification
	 */
	@PostMapping(value = EsopConstant.APPROVE_ALLOCATION)
	public void aproveAllocation(@RequestBody List<Long> allocationId) {
		LOGGER.info("Inside aproveAllocation () of AllocationController allocationId {}: " + allocationId);
		allocationService.approveAllocation(allocationId);
	}
}
