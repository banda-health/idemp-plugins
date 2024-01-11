package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_T_BOMLine;

/**
 * Data Loader for T_BOMLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_T_BOMLineDataLoader extends PODataLoader<X_T_BOMLine> {
	public static String T_BOMLine_BY_ID_DATA_LOADER = "T_BOMLineByIdDataLoader";
	public static String T_BOMLine_BY_UUID_DATA_LOADER = "T_BOMLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_T_BOMLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return T_BOMLine_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return T_BOMLine_BY_UUID_DATA_LOADER;
	}
}
