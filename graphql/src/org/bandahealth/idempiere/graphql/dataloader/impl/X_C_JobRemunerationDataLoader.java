package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_JobRemuneration;

/**
 * Data Loader for C_JobRemuneration - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_JobRemunerationDataLoader extends PODataLoader<X_C_JobRemuneration> {
	public static String C_JobRemuneration_BY_ID_DATA_LOADER = "C_JobRemunerationByIdDataLoader";
	public static String C_JobRemuneration_BY_UUID_DATA_LOADER = "C_JobRemunerationByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_JobRemuneration.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return C_JobRemuneration_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return C_JobRemuneration_BY_UUID_DATA_LOADER;
	}
}
