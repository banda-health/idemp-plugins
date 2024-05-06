package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MStyleLine;

/**
 * Data Loader for AD_StyleLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_StyleLineDataLoader extends PODataLoader<MStyleLine> {
	public static String DATALOADER_AD_StyleLine_BY_ID = "AD_StyleLineByIdDataLoader";
	public static String DATALOADER_AD_StyleLine_BY_UUID = "AD_StyleLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MStyleLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_StyleLine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_StyleLine_BY_UUID;
	}
}
