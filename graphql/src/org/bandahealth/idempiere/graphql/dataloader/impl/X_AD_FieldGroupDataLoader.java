package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MFieldGroup_BH;

/**
 * Data Loader for AD_FieldGroup - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_FieldGroupDataLoader extends PODataLoader<MFieldGroup_BH> {
	public static String DATALOADER_AD_FieldGroup_BY_ID = "AD_FieldGroupByIdDataLoader";
	public static String DATALOADER_AD_FieldGroup_BY_UUID = "AD_FieldGroupByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MFieldGroup_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_FieldGroup_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_FieldGroup_BY_UUID;
	}
}
