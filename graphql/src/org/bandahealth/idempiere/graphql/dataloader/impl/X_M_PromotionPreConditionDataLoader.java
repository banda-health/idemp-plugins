package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_PromotionPreCondition;

/**
 * Data Loader for M_PromotionPreCondition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_PromotionPreConditionDataLoader extends PODataLoader<X_M_PromotionPreCondition> {
	public static String DATALOADER_M_PromotionPreCondition_BY_ID = "M_PromotionPreConditionByIdDataLoader";
	public static String DATALOADER_M_PromotionPreCondition_BY_UUID = "M_PromotionPreConditionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_PromotionPreCondition.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_PromotionPreCondition_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_PromotionPreCondition_BY_UUID;
	}
}
