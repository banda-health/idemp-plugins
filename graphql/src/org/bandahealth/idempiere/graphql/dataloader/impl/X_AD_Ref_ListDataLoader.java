package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MRefList_BH;

/**
 * Data Loader for AD_Ref_List - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Ref_ListDataLoader extends PODataLoader<MRefList_BH> {
	public static String DATALOADER_AD_Ref_List_BY_ID = "AD_Ref_ListByIdDataLoader";
	public static String DATALOADER_AD_Ref_List_BY_UUID = "AD_Ref_ListByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRefList_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Ref_List_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Ref_List_BY_UUID;
	}
}
