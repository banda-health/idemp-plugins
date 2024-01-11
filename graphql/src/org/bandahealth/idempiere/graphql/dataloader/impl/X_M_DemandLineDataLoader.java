package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_DemandLine;

/**
 * Data Loader for M_DemandLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_DemandLineDataLoader extends PODataLoader<X_M_DemandLine> {
	public static String M_DemandLine_BY_ID_DATA_LOADER = "M_DemandLineByIdDataLoader";
	public static String M_DemandLine_BY_UUID_DATA_LOADER = "M_DemandLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_DemandLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_DemandLine_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_DemandLine_BY_UUID_DATA_LOADER;
	}
}
