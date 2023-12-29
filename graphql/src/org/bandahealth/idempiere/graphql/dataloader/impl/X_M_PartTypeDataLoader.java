package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_PartType;

/**
 * Data Loader for M_PartType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_PartTypeDataLoader extends PODataLoader<X_M_PartType> {
	public static String M_PartType_BY_ID_DATA_LOADER = "M_PartTypeByIdDataLoader";
	public static String M_PartType_BY_UUID_DATA_LOADER = "M_PartTypeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_PartType.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_PartType_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_PartType_BY_UUID_DATA_LOADER;
	}
}
