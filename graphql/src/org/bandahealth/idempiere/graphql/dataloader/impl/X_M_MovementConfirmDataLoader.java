package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MMovementConfirm;

/**
 * Data Loader for M_MovementConfirm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_MovementConfirmDataLoader extends PODataLoader<MMovementConfirm> {
	public static String DATALOADER_M_MovementConfirm_BY_ID = "M_MovementConfirmByIdDataLoader";
	public static String DATALOADER_M_MovementConfirm_BY_UUID = "M_MovementConfirmByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MMovementConfirm.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_MovementConfirm_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_MovementConfirm_BY_UUID;
	}
}
