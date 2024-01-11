package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_UserRemuneration;

/**
 * Data Loader for C_UserRemuneration - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_UserRemunerationDataLoader extends PODataLoader<X_C_UserRemuneration> {
	public static String C_UserRemuneration_BY_ID_DATA_LOADER = "C_UserRemunerationByIdDataLoader";
	public static String C_UserRemuneration_BY_UUID_DATA_LOADER = "C_UserRemunerationByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_UserRemuneration.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_UserRemuneration_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_UserRemuneration_BY_UUID_DATA_LOADER;
	}
}
