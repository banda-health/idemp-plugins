package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MInOutLineMA;

/**
 * Data Loader for M_InOutLineMA - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_InOutLineMADataLoader extends PODataLoader<MInOutLineMA> {
	public static String DATALOADER_M_InOutLineMA_BY_ID = "M_InOutLineMAByIdDataLoader";
	public static String DATALOADER_M_InOutLineMA_BY_UUID = "M_InOutLineMAByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MInOutLineMA.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_InOutLineMA_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_InOutLineMA_BY_UUID;
	}
}
