package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_T_InvoiceGL;

/**
 * Data Loader for T_InvoiceGL - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_T_InvoiceGLDataLoader extends PODataLoader<X_T_InvoiceGL> {
	public static String T_InvoiceGL_BY_ID_DATA_LOADER = "T_InvoiceGLByIdDataLoader";
	public static String T_InvoiceGL_BY_UUID_DATA_LOADER = "T_InvoiceGLByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_T_InvoiceGL.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return T_InvoiceGL_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return T_InvoiceGL_BY_UUID_DATA_LOADER;
	}
}
