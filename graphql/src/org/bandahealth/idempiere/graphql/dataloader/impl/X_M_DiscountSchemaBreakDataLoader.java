package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDiscountSchemaBreak;

/**
 * Data Loader for M_DiscountSchemaBreak - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_DiscountSchemaBreakDataLoader extends PODataLoader<MDiscountSchemaBreak> {
	public static String DATALOADER_M_DiscountSchemaBreak_BY_ID = "M_DiscountSchemaBreakByIdDataLoader";
	public static String DATALOADER_M_DiscountSchemaBreak_BY_UUID = "M_DiscountSchemaBreakByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDiscountSchemaBreak.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_DiscountSchemaBreak_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_DiscountSchemaBreak_BY_UUID;
	}
}
