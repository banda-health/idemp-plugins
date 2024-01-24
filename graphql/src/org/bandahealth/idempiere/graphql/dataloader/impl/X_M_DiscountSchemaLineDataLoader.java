package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MDiscountSchemaLine_BH;

/**
 * Data Loader for M_DiscountSchemaLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_DiscountSchemaLineDataLoader extends PODataLoader<MDiscountSchemaLine_BH> {
	public static String DATALOADER_M_DiscountSchemaLine_BY_ID = "M_DiscountSchemaLineByIdDataLoader";
	public static String DATALOADER_M_DiscountSchemaLine_BY_UUID = "M_DiscountSchemaLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDiscountSchemaLine_BH.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_DiscountSchemaLine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_DiscountSchemaLine_BY_UUID;
	}
}
