package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MPostIt;

/**
 * Data Loader for AD_PostIt - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_PostItDataLoader extends PODataLoader<MPostIt> {
	public static String DATALOADER_AD_PostIt_BY_ID = "AD_PostItByIdDataLoader";
	public static String DATALOADER_AD_PostIt_BY_UUID = "AD_PostItByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MPostIt.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_PostIt_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_PostIt_BY_UUID;
	}
}
