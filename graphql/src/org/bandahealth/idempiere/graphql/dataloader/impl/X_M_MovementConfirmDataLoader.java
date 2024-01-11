package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MMovementConfirm;

/**
 * Data Loader for M_MovementConfirm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_MovementConfirmDataLoader extends PODataLoader<MMovementConfirm> {
	public static String M_MovementConfirm_BY_ID_DATA_LOADER = "M_MovementConfirmByIdDataLoader";
	public static String M_MovementConfirm_BY_UUID_DATA_LOADER = "M_MovementConfirmByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MMovementConfirm.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_MovementConfirm_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_MovementConfirm_BY_UUID_DATA_LOADER;
	}
}
