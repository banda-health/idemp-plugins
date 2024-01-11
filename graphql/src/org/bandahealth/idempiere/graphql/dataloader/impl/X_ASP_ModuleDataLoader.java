package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_ASP_Module;

/**
 * Data Loader for ASP_Module - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_ASP_ModuleDataLoader extends PODataLoader<X_ASP_Module> {
	public static String ASP_Module_BY_ID_DATA_LOADER = "ASP_ModuleByIdDataLoader";
	public static String ASP_Module_BY_UUID_DATA_LOADER = "ASP_ModuleByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_ASP_Module.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return ASP_Module_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return ASP_Module_BY_UUID_DATA_LOADER;
	}
}
