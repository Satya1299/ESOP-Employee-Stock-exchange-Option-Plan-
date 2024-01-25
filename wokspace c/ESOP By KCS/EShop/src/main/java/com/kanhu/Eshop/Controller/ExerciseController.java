package com.kanhu.Eshop.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kanhu.Eshop.Constant.EsopConstant;
import com.kanhu.Eshop.Entity.Exercise;
import com.kanhu.Eshop.Service.ExerciseService;

/**
 * @author kanhu charan sahu :-This class exercise controller save the stock
 *         allocated the employee to the database after calculating the process
 *         exercise which required DI of exerciseServise
 */
@RestController
@RequestMapping(value = EsopConstant.FORWORDSLASH)
public class ExerciseController {
	@Autowired
	private ExerciseService exerciseService;
	private static final Logger LOGGER = LoggerFactory.getLogger(ExerciseController.class);

	/**
	 * @param exercise This method both save and update the exercise table after
	 *                 doing the exercising process.
	 */
	@PostMapping(value = EsopConstant.SAVE_EXERCISE)
	public void saveExercise(@RequestBody Exercise exercise) {
		LOGGER.info("Inside saveExercise() of ExerciseController  exercise {}: " + exercise);
		exerciseService.saveExercise(exercise);
	}
}
