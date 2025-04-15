package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRMALine;

/**
 * Data Loader for M_RMALine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_RMALineDataLoader extends PODataLoader<MRMALine> {
	public static String DATALOADER_M_RMALine_BY_ID = "M_RMALineByIdDataLoader";
	public static String DATALOADER_M_RMALine_BY_UUID = "M_RMALineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRMALine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_RMALine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_RMALine_BY_UUID;
	}
}
