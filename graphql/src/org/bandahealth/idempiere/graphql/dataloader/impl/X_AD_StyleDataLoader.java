package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MStyle;

/**
 * Data Loader for AD_Style - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_StyleDataLoader extends PODataLoader<MStyle> {
	public static String AD_Style_BY_ID_DATA_LOADER = "AD_StyleByIdDataLoader";
	public static String AD_Style_BY_UUID_DATA_LOADER = "AD_StyleByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MStyle.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Style_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Style_BY_UUID_DATA_LOADER;
	}
}
