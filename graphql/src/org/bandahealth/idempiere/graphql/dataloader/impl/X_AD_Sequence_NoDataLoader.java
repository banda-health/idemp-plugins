package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_Sequence_No;

/**
 * Data Loader for AD_Sequence_No - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_Sequence_NoDataLoader extends PODataLoader<X_AD_Sequence_No> {
	public static String DATALOADER_AD_Sequence_No_BY_ID = "AD_Sequence_NoByIdDataLoader";
	public static String DATALOADER_AD_Sequence_No_BY_UUID = "AD_Sequence_NoByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_Sequence_No.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Sequence_No_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Sequence_No_BY_UUID;
	}
}
