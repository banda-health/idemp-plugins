package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_Greeting;

/**
 * Data Loader for C_Greeting - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_GreetingDataLoader extends PODataLoader<X_C_Greeting> {
	public static String DATALOADER_C_Greeting_BY_ID = "C_GreetingByIdDataLoader";
	public static String DATALOADER_C_Greeting_BY_UUID = "C_GreetingByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_Greeting.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_Greeting_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_Greeting_BY_UUID;
	}
}
