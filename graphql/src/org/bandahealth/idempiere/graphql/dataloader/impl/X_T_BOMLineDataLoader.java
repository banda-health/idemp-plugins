package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.eevolution.model.X_T_BOMLine;

/**
 * Data Loader for T_BOMLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_T_BOMLineDataLoader extends PODataLoader<X_T_BOMLine> {
	public static String DATALOADER_T_BOMLine_BY_ID = "T_BOMLineByIdDataLoader";
	public static String DATALOADER_T_BOMLine_BY_UUID = "T_BOMLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_T_BOMLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_T_BOMLine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_T_BOMLine_BY_UUID;
	}
}
