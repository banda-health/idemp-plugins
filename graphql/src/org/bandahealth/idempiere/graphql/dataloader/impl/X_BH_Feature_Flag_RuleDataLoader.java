package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHFeatureFlagRule;

/**
 * Data Loader for BH_Feature_Flag_Rule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Feature_Flag_RuleDataLoader extends PODataLoader<MBHFeatureFlagRule> {
	public static String DATALOADER_BH_Feature_Flag_Rule_BY_ID = "BH_Feature_Flag_RuleByIdDataLoader";
	public static String DATALOADER_BH_Feature_Flag_Rule_BY_UUID = "BH_Feature_Flag_RuleByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHFeatureFlagRule.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_Feature_Flag_Rule_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_Feature_Flag_Rule_BY_UUID;
	}
}
