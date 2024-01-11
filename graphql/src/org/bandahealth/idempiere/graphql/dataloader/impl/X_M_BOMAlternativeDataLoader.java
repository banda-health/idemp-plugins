package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_BOMAlternative;

/**
 * Data Loader for M_BOMAlternative - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_BOMAlternativeDataLoader extends PODataLoader<X_M_BOMAlternative> {
	public static String M_BOMAlternative_BY_ID_DATA_LOADER = "M_BOMAlternativeByIdDataLoader";
	public static String M_BOMAlternative_BY_UUID_DATA_LOADER = "M_BOMAlternativeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_BOMAlternative.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_BOMAlternative_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_BOMAlternative_BY_UUID_DATA_LOADER;
	}
}
