package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MMovementLine_BH;

/**
 * Data Loader for M_MovementLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_MovementLineDataLoader extends PODataLoader<MMovementLine_BH> {
	public static String DATALOADER_M_MovementLine_BY_ID = "M_MovementLineByIdDataLoader";
	public static String DATALOADER_M_MovementLine_BY_UUID = "M_MovementLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MMovementLine_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_MovementLine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_MovementLine_BY_UUID;
	}
}
