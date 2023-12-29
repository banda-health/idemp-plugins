package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MReference_BH;

/**
 * Data Loader for AD_Reference - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ReferenceDataLoader extends PODataLoader<MReference_BH> {
	public static String AD_Reference_BY_ID_DATA_LOADER = "AD_ReferenceByIdDataLoader";
	public static String AD_Reference_BY_UUID_DATA_LOADER = "AD_ReferenceByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MReference_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Reference_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Reference_BY_UUID_DATA_LOADER;
	}
}
