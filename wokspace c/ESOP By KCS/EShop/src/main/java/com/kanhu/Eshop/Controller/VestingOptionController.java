package com.kanhu.Eshop.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kanhu.Eshop.Constant.EsopConstant;
import com.kanhu.Eshop.Dto.VestingOptionDto;
import com.kanhu.Eshop.Service.VestingOptionService;

/**
 * @author kanhu charan sahu This class control the vestingOption which is
 *         vesting factor and date updated in grant table By help of
 *         vestingServse DI.
 */
@RestController
@RequestMapping(value = EsopConstant.FORWORDSLASH)
public class VestingOptionController {
	@Autowired
	private VestingOptionService vestingOptionService;
	private static final Logger LOGGER = LoggerFactory.getLogger(VestingOptionController.class);

	/**
	 * @param vestingOptionDto his method update the grant table after calculating
	 *                         the vesting option of total investment
	 */
	@PostMapping(value = EsopConstant.SAVE_VESTING_OPTION)
	public void saveVestingOption(VestingOptionDto vestingOptionDto) {
		LOGGER.info("Inside saveVestingOption() ofVestingOptionController  vestingOptionDto {}: " + vestingOptionDto);
		vestingOptionService.updatePlanByVestingDto(vestingOptionDto);
	}
}
