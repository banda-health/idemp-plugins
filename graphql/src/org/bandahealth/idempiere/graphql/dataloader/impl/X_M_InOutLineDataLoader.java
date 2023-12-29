package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MInOutLine;

/**
 * Data Loader for M_InOutLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_InOutLineDataLoader extends PODataLoader<MInOutLine> {
	public static String M_InOutLine_BY_ID_DATA_LOADER = "M_InOutLineByIdDataLoader";
	public static String M_InOutLine_BY_UUID_DATA_LOADER = "M_InOutLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MInOutLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_InOutLine_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_InOutLine_BY_UUID_DATA_LOADER;
	}
}
