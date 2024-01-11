package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_Substitute;

/**
 * Data Loader for M_Substitute - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_SubstituteDataLoader extends PODataLoader<X_M_Substitute> {
	public static String M_Substitute_BY_ID_DATA_LOADER = "M_SubstituteByIdDataLoader";
	public static String M_Substitute_BY_UUID_DATA_LOADER = "M_SubstituteByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_Substitute.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_Substitute_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_Substitute_BY_UUID_DATA_LOADER;
	}
}
