package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_A_RegistrationProduct;

/**
 * Data Loader for A_RegistrationProduct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_A_RegistrationProductDataLoader extends PODataLoader<X_A_RegistrationProduct> {
	public static String DATALOADER_A_RegistrationProduct_BY_ID = "A_RegistrationProductByIdDataLoader";
	public static String DATALOADER_A_RegistrationProduct_BY_UUID = "A_RegistrationProductByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_A_RegistrationProduct.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_A_RegistrationProduct_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_A_RegistrationProduct_BY_UUID;
	}
}
