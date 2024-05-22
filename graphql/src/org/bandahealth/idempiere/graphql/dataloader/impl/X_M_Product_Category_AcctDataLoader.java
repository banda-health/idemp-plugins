package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MProductCategoryAcct;

/**
 * Data Loader for M_Product_Category_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_Product_Category_AcctDataLoader extends PODataLoader<MProductCategoryAcct> {
	public static String DATALOADER_M_Product_Category_Acct_BY_ID = "M_Product_Category_AcctByIdDataLoader";
	public static String DATALOADER_M_Product_Category_Acct_BY_UUID = "M_Product_Category_AcctByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MProductCategoryAcct.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_Product_Category_Acct_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_Product_Category_Acct_BY_UUID;
	}
}
