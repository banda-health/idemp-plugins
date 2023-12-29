package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRMALine;

/**
 * Data Loader for M_RMALine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_RMALineDataLoader extends PODataLoader<MRMALine> {
	public static String M_RMALine_BY_ID_DATA_LOADER = "M_RMALineByIdDataLoader";
	public static String M_RMALine_BY_UUID_DATA_LOADER = "M_RMALineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRMALine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_RMALine_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_RMALine_BY_UUID_DATA_LOADER;
	}
}
