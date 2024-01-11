package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MStyleLine;

/**
 * Data Loader for AD_StyleLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_StyleLineDataLoader extends PODataLoader<MStyleLine> {
	public static String AD_StyleLine_BY_ID_DATA_LOADER = "AD_StyleLineByIdDataLoader";
	public static String AD_StyleLine_BY_UUID_DATA_LOADER = "AD_StyleLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MStyleLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_StyleLine_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_StyleLine_BY_UUID_DATA_LOADER;
	}
}
