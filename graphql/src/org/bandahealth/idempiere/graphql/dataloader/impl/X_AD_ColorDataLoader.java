package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MColor;

/**
 * Data Loader for AD_Color - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ColorDataLoader extends PODataLoader<MColor> {
	public static String AD_Color_BY_ID_DATA_LOADER = "AD_ColorByIdDataLoader";
	public static String AD_Color_BY_UUID_DATA_LOADER = "AD_ColorByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MColor.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Color_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Color_BY_UUID_DATA_LOADER;
	}
}
