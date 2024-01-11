package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_ASP_Ref_List;

/**
 * Data Loader for ASP_Ref_List - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_ASP_Ref_ListDataLoader extends PODataLoader<X_ASP_Ref_List> {
	public static String ASP_Ref_List_BY_ID_DATA_LOADER = "ASP_Ref_ListByIdDataLoader";
	public static String ASP_Ref_List_BY_UUID_DATA_LOADER = "ASP_Ref_ListByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_ASP_Ref_List.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return ASP_Ref_List_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return ASP_Ref_List_BY_UUID_DATA_LOADER;
	}
}
