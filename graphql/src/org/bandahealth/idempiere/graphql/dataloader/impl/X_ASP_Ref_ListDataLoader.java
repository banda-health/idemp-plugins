package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_ASP_Ref_List;

/**
 * Data Loader for ASP_Ref_List - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_ASP_Ref_ListDataLoader extends PODataLoader<X_ASP_Ref_List> {
	public static String DATALOADER_ASP_Ref_List_BY_ID = "ASP_Ref_ListByIdDataLoader";
	public static String DATALOADER_ASP_Ref_List_BY_UUID = "ASP_Ref_ListByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_ASP_Ref_List.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_ASP_Ref_List_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_ASP_Ref_List_BY_UUID;
	}
}
