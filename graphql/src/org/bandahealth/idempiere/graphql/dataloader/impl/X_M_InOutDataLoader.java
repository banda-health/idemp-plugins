package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MInOut_BH;

/**
 * Data Loader for M_InOut - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_InOutDataLoader extends PODataLoader<MInOut_BH> {
	public static String DATALOADER_M_InOut_BY_ID = "M_InOutByIdDataLoader";
	public static String DATALOADER_M_InOut_BY_UUID = "M_InOutByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MInOut_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_InOut_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_InOut_BY_UUID;
	}
}
