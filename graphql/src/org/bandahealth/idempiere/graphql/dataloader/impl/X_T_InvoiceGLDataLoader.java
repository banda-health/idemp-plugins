package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_T_InvoiceGL;

/**
 * Data Loader for T_InvoiceGL - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_T_InvoiceGLDataLoader extends PODataLoader<X_T_InvoiceGL> {
	public static String DATALOADER_T_InvoiceGL_BY_ID = "T_InvoiceGLByIdDataLoader";
	public static String DATALOADER_T_InvoiceGL_BY_UUID = "T_InvoiceGLByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_T_InvoiceGL.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_T_InvoiceGL_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_T_InvoiceGL_BY_UUID;
	}
}
