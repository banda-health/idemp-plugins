package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDiscountSchemaBreak;

/**
 * Data Loader for M_DiscountSchemaBreak - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_DiscountSchemaBreakDataLoader extends PODataLoader<MDiscountSchemaBreak> {
	public static String M_DiscountSchemaBreak_BY_ID_DATA_LOADER = "M_DiscountSchemaBreakByIdDataLoader";
	public static String M_DiscountSchemaBreak_BY_UUID_DATA_LOADER = "M_DiscountSchemaBreakByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDiscountSchemaBreak.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_DiscountSchemaBreak_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_DiscountSchemaBreak_BY_UUID_DATA_LOADER;
	}
}
