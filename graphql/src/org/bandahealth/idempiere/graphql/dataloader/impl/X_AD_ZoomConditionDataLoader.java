package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MZoomCondition;

/**
 * Data Loader for AD_ZoomCondition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ZoomConditionDataLoader extends PODataLoader<MZoomCondition> {
	public static String AD_ZoomCondition_BY_ID_DATA_LOADER = "AD_ZoomConditionByIdDataLoader";
	public static String AD_ZoomCondition_BY_UUID_DATA_LOADER = "AD_ZoomConditionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MZoomCondition.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_ZoomCondition_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_ZoomCondition_BY_UUID_DATA_LOADER;
	}
}
