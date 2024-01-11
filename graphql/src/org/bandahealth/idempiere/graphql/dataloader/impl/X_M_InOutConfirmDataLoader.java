package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MInOutConfirm;

/**
 * Data Loader for M_InOutConfirm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_InOutConfirmDataLoader extends PODataLoader<MInOutConfirm> {
	public static String M_InOutConfirm_BY_ID_DATA_LOADER = "M_InOutConfirmByIdDataLoader";
	public static String M_InOutConfirm_BY_UUID_DATA_LOADER = "M_InOutConfirmByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MInOutConfirm.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_InOutConfirm_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_InOutConfirm_BY_UUID_DATA_LOADER;
	}
}
