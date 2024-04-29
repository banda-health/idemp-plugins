package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MOrderLine_BH;

/**
 * Data Loader for C_OrderLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_OrderLineDataLoader extends PODataLoader<MOrderLine_BH> {
	public static String DATALOADER_C_OrderLine_BY_ID = "C_OrderLineByIdDataLoader";
	public static String DATALOADER_C_OrderLine_BY_UUID = "C_OrderLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MOrderLine_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_OrderLine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_OrderLine_BY_UUID;
	}
}
