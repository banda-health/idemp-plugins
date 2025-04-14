package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MInOutConfirm;

/**
 * Data Loader for M_InOutConfirm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_InOutConfirmDataLoader extends PODataLoader<MInOutConfirm> {
	public static String DATALOADER_M_InOutConfirm_BY_ID = "M_InOutConfirmByIdDataLoader";
	public static String DATALOADER_M_InOutConfirm_BY_UUID = "M_InOutConfirmByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MInOutConfirm.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_InOutConfirm_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_InOutConfirm_BY_UUID;
	}
}
