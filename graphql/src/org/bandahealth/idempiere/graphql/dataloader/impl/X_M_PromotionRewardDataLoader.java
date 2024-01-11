package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_PromotionReward;

/**
 * Data Loader for M_PromotionReward - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_PromotionRewardDataLoader extends PODataLoader<X_M_PromotionReward> {
	public static String M_PromotionReward_BY_ID_DATA_LOADER = "M_PromotionRewardByIdDataLoader";
	public static String M_PromotionReward_BY_UUID_DATA_LOADER = "M_PromotionRewardByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_PromotionReward.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_PromotionReward_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_PromotionReward_BY_UUID_DATA_LOADER;
	}
}
