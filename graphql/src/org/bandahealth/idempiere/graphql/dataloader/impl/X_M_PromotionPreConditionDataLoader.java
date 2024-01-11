package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_PromotionPreCondition;

/**
 * Data Loader for M_PromotionPreCondition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_PromotionPreConditionDataLoader extends PODataLoader<X_M_PromotionPreCondition> {
	public static String M_PromotionPreCondition_BY_ID_DATA_LOADER = "M_PromotionPreConditionByIdDataLoader";
	public static String M_PromotionPreCondition_BY_UUID_DATA_LOADER = "M_PromotionPreConditionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_PromotionPreCondition.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_PromotionPreCondition_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_PromotionPreCondition_BY_UUID_DATA_LOADER;
	}
}
