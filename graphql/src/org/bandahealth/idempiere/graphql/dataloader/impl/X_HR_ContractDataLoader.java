package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_HR_Contract;

/**
 * Data Loader for HR_Contract - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_HR_ContractDataLoader extends PODataLoader<X_HR_Contract> {
	public static String HR_Contract_BY_ID_DATA_LOADER = "HR_ContractByIdDataLoader";
	public static String HR_Contract_BY_UUID_DATA_LOADER = "HR_ContractByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_HR_Contract.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return HR_Contract_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return HR_Contract_BY_UUID_DATA_LOADER;
	}
}
