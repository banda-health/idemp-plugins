package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MSerNoCtl_BH;

/**
 * Data Loader for M_SerNoCtl - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_SerNoCtlDataLoader extends PODataLoader<MSerNoCtl_BH> {
	public static String DATALOADER_M_SerNoCtl_BY_ID = "M_SerNoCtlByIdDataLoader";
	public static String DATALOADER_M_SerNoCtl_BY_UUID = "M_SerNoCtlByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MSerNoCtl_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_SerNoCtl_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_SerNoCtl_BY_UUID;
	}
}
