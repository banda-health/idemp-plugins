package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPostIt;

/**
 * Data Loader for AD_PostIt - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_PostItDataLoader extends PODataLoader<MPostIt> {
	public static String AD_PostIt_BY_ID_DATA_LOADER = "AD_PostItByIdDataLoader";
	public static String AD_PostIt_BY_UUID_DATA_LOADER = "AD_PostItByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPostIt.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_PostIt_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_PostIt_BY_UUID_DATA_LOADER;
	}
}
