package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MInOutLine;

/**
 * Data Loader for M_InOutLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_InOutLineDataLoader extends PODataLoader<MInOutLine> {
	public static String DATALOADER_M_InOutLine_BY_ID = "M_InOutLineByIdDataLoader";
	public static String DATALOADER_M_InOutLine_BY_UUID = "M_InOutLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MInOutLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_InOutLine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_InOutLine_BY_UUID;
	}
}
