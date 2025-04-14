package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_Product_Acct;

/**
 * Data Loader for M_Product_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_Product_AcctDataLoader extends PODataLoader<X_M_Product_Acct> {
	public static String DATALOADER_M_Product_Acct_BY_ID = "M_Product_AcctByIdDataLoader";
	public static String DATALOADER_M_Product_Acct_BY_UUID = "M_Product_AcctByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_Product_Acct.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_Product_Acct_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_Product_Acct_BY_UUID;
	}
}
