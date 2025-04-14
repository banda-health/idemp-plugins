package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_ASP_Module;

/**
 * Data Loader for ASP_Module - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_ASP_ModuleDataLoader extends PODataLoader<X_ASP_Module> {
	public static String DATALOADER_ASP_Module_BY_ID = "ASP_ModuleByIdDataLoader";
	public static String DATALOADER_ASP_Module_BY_UUID = "ASP_ModuleByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_ASP_Module.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_ASP_Module_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_ASP_Module_BY_UUID;
	}
}
