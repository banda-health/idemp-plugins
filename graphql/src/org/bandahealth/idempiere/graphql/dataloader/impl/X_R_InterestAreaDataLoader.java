package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MInterestArea;

/**
 * Data Loader for R_InterestArea - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_R_InterestAreaDataLoader extends PODataLoader<MInterestArea> {
	public static String DATALOADER_R_InterestArea_BY_ID = "R_InterestAreaByIdDataLoader";
	public static String DATALOADER_R_InterestArea_BY_UUID = "R_InterestAreaByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MInterestArea.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_R_InterestArea_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_R_InterestArea_BY_UUID;
	}
}
