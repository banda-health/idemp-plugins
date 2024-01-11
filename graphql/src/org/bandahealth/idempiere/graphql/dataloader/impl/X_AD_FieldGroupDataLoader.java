package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MFieldGroup_BH;

/**
 * Data Loader for AD_FieldGroup - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_FieldGroupDataLoader extends PODataLoader<MFieldGroup_BH> {
	public static String AD_FieldGroup_BY_ID_DATA_LOADER = "AD_FieldGroupByIdDataLoader";
	public static String AD_FieldGroup_BY_UUID_DATA_LOADER = "AD_FieldGroupByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MFieldGroup_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_FieldGroup_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_FieldGroup_BY_UUID_DATA_LOADER;
	}
}
