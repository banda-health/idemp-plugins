package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDiscountSchema;

/**
 * Data Loader for M_DiscountSchema - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_DiscountSchemaDataLoader extends PODataLoader<MDiscountSchema> {
	public static String M_DiscountSchema_BY_ID_DATA_LOADER = "M_DiscountSchemaByIdDataLoader";
	public static String M_DiscountSchema_BY_UUID_DATA_LOADER = "M_DiscountSchemaByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDiscountSchema.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_DiscountSchema_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_DiscountSchema_BY_UUID_DATA_LOADER;
	}
}
