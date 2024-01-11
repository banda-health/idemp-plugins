package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MInterestArea;

/**
 * Data Loader for R_InterestArea - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_InterestAreaDataLoader extends PODataLoader<MInterestArea> {
	public static String R_InterestArea_BY_ID_DATA_LOADER = "R_InterestAreaByIdDataLoader";
	public static String R_InterestArea_BY_UUID_DATA_LOADER = "R_InterestAreaByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MInterestArea.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return R_InterestArea_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return R_InterestArea_BY_UUID_DATA_LOADER;
	}
}
