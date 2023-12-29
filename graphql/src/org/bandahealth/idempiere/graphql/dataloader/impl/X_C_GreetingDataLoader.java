package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_Greeting;

/**
 * Data Loader for C_Greeting - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_GreetingDataLoader extends PODataLoader<X_C_Greeting> {
	public static String C_Greeting_BY_ID_DATA_LOADER = "C_GreetingByIdDataLoader";
	public static String C_Greeting_BY_UUID_DATA_LOADER = "C_GreetingByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_Greeting.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_Greeting_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_Greeting_BY_UUID_DATA_LOADER;
	}
}
