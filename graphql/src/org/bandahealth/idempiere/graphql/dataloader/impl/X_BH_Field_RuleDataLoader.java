package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHFieldRule;

/**
 * Data Loader for BH_Field_Rule - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Field_RuleDataLoader extends PODataLoader<MBHFieldRule> {
	public static String DATALOADER_BH_Field_Rule_BY_ID = "BH_Field_RuleByIdDataLoader";
	public static String DATALOADER_BH_Field_Rule_BY_UUID = "BH_Field_RuleByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHFieldRule.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_Field_Rule_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_Field_Rule_BY_UUID;
	}
}
