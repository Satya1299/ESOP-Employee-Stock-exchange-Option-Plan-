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
import com.kanhu.Eshop.Dto.GrantDto;

import com.kanhu.Eshop.Service.GrantService;

/**
 * @author kanhu charan sahu
 * This class Grant controller save the Grant
 *         of define plan the employee to save the database and approving grand and after that last fixing
 *     the lock of the grant  which is doing by required DI of grantServise
 *
 */
@RestController
@RequestMapping(value = EsopConstant.FORWORDSLASH)
public class GrantController {

	@Autowired
	private GrantService grantService;
	private static final Logger LOGGER = LoggerFactory.getLogger(GrantController.class);
	/**
	 * @param grantDtos to save the list of grant object using dto object
	 */
	@PostMapping(value = EsopConstant.SAVE_GRAND_LIST)
	public void saveGrantList(@RequestBody List<GrantDto> grantDtos) {
		LOGGER.info("Inside saveGrantList() of GrantController  grantDtos {}: " + grantDtos);
		grantService.saveGrand(grantDtos);
	}

	/**
	 * @param grantIdList
	 * After processing status approve the grant throught grantlist id
	 */
	@PostMapping(value = EsopConstant.GRAND_STATUS_UPDATE)
	public void approvedGrandStatus(@RequestBody List<Long> grantIdList) {
		LOGGER.info("Inside approvedGrandStatus() of GrantController grantIdList{}: " + grantIdList);
		grantService.approveGrants(grantIdList);
	}

	/**
	 * @param id Finally after allocation the grant to employee lock the stock
	 *           amount for required years by help of grant id
	 */
	@PostMapping(value = EsopConstant.UPDATE_LOCKING_STATUS)
	public void fixLockingToStock(@RequestBody Long id) {
		LOGGER.info("Inside fixLockingToStock() of GrantController  id {}: " + id);
		grantService.updateLock(id);
	}
}
