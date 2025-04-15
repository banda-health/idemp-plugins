package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MStyle;

/**
 * Data Loader for AD_Style - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_StyleDataLoader extends PODataLoader<MStyle> {
	public static String DATALOADER_AD_Style_BY_ID = "AD_StyleByIdDataLoader";
	public static String DATALOADER_AD_Style_BY_UUID = "AD_StyleByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MStyle.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Style_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Style_BY_UUID;
	}
}
