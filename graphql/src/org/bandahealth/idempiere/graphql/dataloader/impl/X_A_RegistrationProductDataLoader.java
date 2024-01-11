package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_A_RegistrationProduct;

/**
 * Data Loader for A_RegistrationProduct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_RegistrationProductDataLoader extends PODataLoader<X_A_RegistrationProduct> {
	public static String A_RegistrationProduct_BY_ID_DATA_LOADER = "A_RegistrationProductByIdDataLoader";
	public static String A_RegistrationProduct_BY_UUID_DATA_LOADER = "A_RegistrationProductByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_A_RegistrationProduct.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return A_RegistrationProduct_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return A_RegistrationProduct_BY_UUID_DATA_LOADER;
	}
}
