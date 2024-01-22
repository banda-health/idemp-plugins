package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_PromotionReward;

/**
 * Data Loader for M_PromotionReward - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_PromotionRewardDataLoader extends PODataLoader<X_M_PromotionReward> {
	public static String DATALOADER_M_PromotionReward_BY_ID = "M_PromotionRewardByIdDataLoader";
	public static String DATALOADER_M_PromotionReward_BY_UUID = "M_PromotionRewardByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_PromotionReward.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_PromotionReward_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_PromotionReward_BY_UUID;
	}
}
