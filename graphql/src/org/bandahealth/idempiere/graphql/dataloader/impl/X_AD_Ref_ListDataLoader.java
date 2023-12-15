package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRefList;

public class X_AD_Ref_ListDataLoader extends PODataLoader<MRefList> {
	public static String AD_Ref_List_BY_ID_DATA_LOADER = "AD_Ref_ListByIdDataLoader";
	public static String AD_Ref_List_BY_UUID_DATA_LOADER = "AD_Ref_ListByUuidDataLoader";

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Ref_List_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Ref_List_BY_UUID_DATA_LOADER;
	}

	@Override
	protected String getEntityTableName() {
		return MRefList.Table_Name;
	}
}
