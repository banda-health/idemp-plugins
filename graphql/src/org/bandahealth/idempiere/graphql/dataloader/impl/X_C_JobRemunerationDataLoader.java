package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_C_JobRemuneration;

/**
 * Data Loader for C_JobRemuneration - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_JobRemunerationDataLoader extends PODataLoader<X_C_JobRemuneration> {
	public static String DATALOADER_C_JobRemuneration_BY_ID = "C_JobRemunerationByIdDataLoader";
	public static String DATALOADER_C_JobRemuneration_BY_UUID = "C_JobRemunerationByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_C_JobRemuneration.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_JobRemuneration_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_JobRemuneration_BY_UUID;
	}
}
