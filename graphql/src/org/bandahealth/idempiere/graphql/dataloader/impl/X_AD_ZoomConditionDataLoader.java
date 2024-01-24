package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MZoomCondition;

/**
 * Data Loader for AD_ZoomCondition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_ZoomConditionDataLoader extends PODataLoader<MZoomCondition> {
	public static String DATALOADER_AD_ZoomCondition_BY_ID = "AD_ZoomConditionByIdDataLoader";
	public static String DATALOADER_AD_ZoomCondition_BY_UUID = "AD_ZoomConditionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MZoomCondition.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_ZoomCondition_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_ZoomCondition_BY_UUID;
	}
}
