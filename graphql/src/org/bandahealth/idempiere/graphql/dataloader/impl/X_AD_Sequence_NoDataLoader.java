package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_AD_Sequence_No;

/**
 * Data Loader for AD_Sequence_No - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Sequence_NoDataLoader extends PODataLoader<X_AD_Sequence_No> {
	public static String AD_Sequence_No_BY_ID_DATA_LOADER = "AD_Sequence_NoByIdDataLoader";
	public static String AD_Sequence_No_BY_UUID_DATA_LOADER = "AD_Sequence_NoByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_AD_Sequence_No.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Sequence_No_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Sequence_No_BY_UUID_DATA_LOADER;
	}
}
