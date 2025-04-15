package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MReference_BH;

/**
 * Data Loader for AD_Reference - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_ReferenceDataLoader extends PODataLoader<MReference_BH> {
	public static String DATALOADER_AD_Reference_BY_ID = "AD_ReferenceByIdDataLoader";
	public static String DATALOADER_AD_Reference_BY_UUID = "AD_ReferenceByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MReference_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Reference_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Reference_BY_UUID;
	}
}
