package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MResolution;

/**
 * Data Loader for R_Resolution - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_R_ResolutionDataLoader extends PODataLoader<MResolution> {
	public static String DATALOADER_R_Resolution_BY_ID = "R_ResolutionByIdDataLoader";
	public static String DATALOADER_R_Resolution_BY_UUID = "R_ResolutionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MResolution.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_R_Resolution_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_R_Resolution_BY_UUID;
	}
}
