package com.kanhu.Eshop.Constant;

/**
 * @author Kanhu Charan Sahu
 *Here all constant of Esop like table name and all controller class methods name as per mapping request
 */
public interface EsopConstant {
	public static String PLAN_TABLE = "plan_info";
	public static String GRANT_TABLE = "garnt_info";
	public static String EMPLOYEE_TABLE = "employee_info";
	public static String ALLOCATION_TABLE = "allocaion_info";
	public static String EXERCISE_TABLE = "exercise_info";
	public static String VESTED_OPTION_TABLE = "vesting_option_info";
	public static String FORWORDSLASH = "/";
	public static String SAVE_PLAN = "/subScribePlan";
	public static String SAVE_GRAND_LIST = "/saveGrantList";
	public static String GET_ACTIVEPLAN_BY_PLAN_YEAR = "/getActivePlanByPlanYear";
	public static String GRAND_STATUS_UPDATE = "/ approvedGrandStatus";
	public static String APPROVE_ALLOCATION = "/aproveAllocation";
	public static String SAVE_VESTING_OPTION = "/saveVestingOption";
	public static String SAVE_EXERCISE = "/saveExercise";
	public static String UPDATE_LOCKING_STATUS = "/fixLockingToStock";
}
