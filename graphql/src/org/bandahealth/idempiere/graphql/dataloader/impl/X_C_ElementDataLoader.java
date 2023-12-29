package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MElement;

/**
 * Data Loader for C_Element - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_ElementDataLoader extends PODataLoader<MElement> {
	public static String C_Element_BY_ID_DATA_LOADER = "C_ElementByIdDataLoader";
	public static String C_Element_BY_UUID_DATA_LOADER = "C_ElementByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MElement.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_Element_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_Element_BY_UUID_DATA_LOADER;
	}
}
