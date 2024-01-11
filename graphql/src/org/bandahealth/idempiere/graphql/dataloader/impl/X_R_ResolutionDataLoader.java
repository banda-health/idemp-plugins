package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MResolution;

/**
 * Data Loader for R_Resolution - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_ResolutionDataLoader extends PODataLoader<MResolution> {
	public static String R_Resolution_BY_ID_DATA_LOADER = "R_ResolutionByIdDataLoader";
	public static String R_Resolution_BY_UUID_DATA_LOADER = "R_ResolutionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MResolution.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return R_Resolution_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return R_Resolution_BY_UUID_DATA_LOADER;
	}
}
