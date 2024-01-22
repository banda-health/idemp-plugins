package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_ASP_ClientException;

/**
 * Data Loader for ASP_ClientException - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_ASP_ClientExceptionDataLoader extends PODataLoader<X_ASP_ClientException> {
	public static String DATALOADER_ASP_ClientException_BY_ID = "ASP_ClientExceptionByIdDataLoader";
	public static String DATALOADER_ASP_ClientException_BY_UUID = "ASP_ClientExceptionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_ASP_ClientException.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_ASP_ClientException_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_ASP_ClientException_BY_UUID;
	}
}
