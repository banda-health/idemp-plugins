package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MMovementLineMA;

/**
 * Data Loader for M_MovementLineMA - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_MovementLineMADataLoader extends PODataLoader<MMovementLineMA> {
	public static String DATALOADER_M_MovementLineMA_BY_ID = "M_MovementLineMAByIdDataLoader";
	public static String DATALOADER_M_MovementLineMA_BY_UUID = "M_MovementLineMAByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MMovementLineMA.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_MovementLineMA_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_MovementLineMA_BY_UUID;
	}
}
