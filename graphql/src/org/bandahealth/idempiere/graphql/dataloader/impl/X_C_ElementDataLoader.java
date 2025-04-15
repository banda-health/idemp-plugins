package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MElement;

/**
 * Data Loader for C_Element - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_ElementDataLoader extends PODataLoader<MElement> {
	public static String DATALOADER_C_Element_BY_ID = "C_ElementByIdDataLoader";
	public static String DATALOADER_C_Element_BY_UUID = "C_ElementByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MElement.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_Element_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_Element_BY_UUID;
	}
}
