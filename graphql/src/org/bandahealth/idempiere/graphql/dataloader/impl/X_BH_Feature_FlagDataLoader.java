package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHFeatureFlag;

/**
 * Data Loader for BH_Feature_Flag - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Feature_FlagDataLoader extends PODataLoader<MBHFeatureFlag> {
	public static String DATALOADER_BH_Feature_Flag_BY_ID = "BH_Feature_FlagByIdDataLoader";
	public static String DATALOADER_BH_Feature_Flag_BY_UUID = "BH_Feature_FlagByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHFeatureFlag.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_Feature_Flag_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_Feature_Flag_BY_UUID;
	}
}
