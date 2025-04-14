package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_DemandLine;

/**
 * Data Loader for M_DemandLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_DemandLineDataLoader extends PODataLoader<X_M_DemandLine> {
	public static String DATALOADER_M_DemandLine_BY_ID = "M_DemandLineByIdDataLoader";
	public static String DATALOADER_M_DemandLine_BY_UUID = "M_DemandLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_DemandLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_DemandLine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_DemandLine_BY_UUID;
	}
}
