package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_HR_Contract;

/**
 * Data Loader for HR_Contract - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_HR_ContractDataLoader extends PODataLoader<X_HR_Contract> {
	public static String DATALOADER_HR_Contract_BY_ID = "HR_ContractByIdDataLoader";
	public static String DATALOADER_HR_Contract_BY_UUID = "HR_ContractByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_HR_Contract.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_HR_Contract_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_HR_Contract_BY_UUID;
	}
}
