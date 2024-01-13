package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MUserDefInfoRelated;

/**
 * Data Loader for AD_UserDef_Info_Related - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_UserDef_Info_RelatedDataLoader extends PODataLoader<MUserDefInfoRelated> {
	public static String DATALOADER_AD_UserDef_Info_Related_BY_ID = "AD_UserDef_Info_RelatedByIdDataLoader";
	public static String DATALOADER_AD_UserDef_Info_Related_BY_UUID = "AD_UserDef_Info_RelatedByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MUserDefInfoRelated.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_UserDef_Info_Related_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_UserDef_Info_Related_BY_UUID;
	}
}
