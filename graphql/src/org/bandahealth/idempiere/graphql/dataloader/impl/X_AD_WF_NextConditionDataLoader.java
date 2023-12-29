package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_WF_NextCondition;

/**
 * Data Loader for AD_WF_NextCondition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WF_NextConditionDataLoader extends PODataLoader<X_AD_WF_NextCondition> {
	public static String AD_WF_NextCondition_BY_ID_DATA_LOADER = "AD_WF_NextConditionByIdDataLoader";
	public static String AD_WF_NextCondition_BY_UUID_DATA_LOADER = "AD_WF_NextConditionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_WF_NextCondition.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_WF_NextCondition_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_WF_NextCondition_BY_UUID_DATA_LOADER;
	}
}
