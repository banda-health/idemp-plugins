package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MWebProperties;

/**
 * Data Loader for U_Web_Properties - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_U_Web_PropertiesDataLoader extends PODataLoader<MWebProperties> {
	public static String U_Web_Properties_BY_ID_DATA_LOADER = "U_Web_PropertiesByIdDataLoader";
	public static String U_Web_Properties_BY_UUID_DATA_LOADER = "U_Web_PropertiesByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MWebProperties.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return U_Web_Properties_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return U_Web_Properties_BY_UUID_DATA_LOADER;
	}
}
