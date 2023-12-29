package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAddressValidation;

/**
 * Data Loader for C_AddressValidation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_AddressValidationDataLoader extends PODataLoader<MAddressValidation> {
	public static String C_AddressValidation_BY_ID_DATA_LOADER = "C_AddressValidationByIdDataLoader";
	public static String C_AddressValidation_BY_UUID_DATA_LOADER = "C_AddressValidationByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAddressValidation.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_AddressValidation_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_AddressValidation_BY_UUID_DATA_LOADER;
	}
}
