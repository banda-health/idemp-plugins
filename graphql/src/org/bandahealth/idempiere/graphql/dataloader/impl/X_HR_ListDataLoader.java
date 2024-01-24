package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_HR_List;

/**
 * Data Loader for HR_List - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_HR_ListDataLoader extends PODataLoader<X_HR_List> {
	public static String DATALOADER_HR_List_BY_ID = "HR_ListByIdDataLoader";
	public static String DATALOADER_HR_List_BY_UUID = "HR_ListByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_HR_List.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_HR_List_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_HR_List_BY_UUID;
	}
}
