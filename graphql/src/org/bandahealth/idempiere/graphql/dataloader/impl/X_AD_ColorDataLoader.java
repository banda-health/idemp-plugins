package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MColor;

/**
 * Data Loader for AD_Color - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_ColorDataLoader extends PODataLoader<MColor> {
	public static String DATALOADER_AD_Color_BY_ID = "AD_ColorByIdDataLoader";
	public static String DATALOADER_AD_Color_BY_UUID = "AD_ColorByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MColor.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Color_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Color_BY_UUID;
	}
}
