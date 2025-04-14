package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDiscountSchema;

/**
 * Data Loader for M_DiscountSchema - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_DiscountSchemaDataLoader extends PODataLoader<MDiscountSchema> {
	public static String DATALOADER_M_DiscountSchema_BY_ID = "M_DiscountSchemaByIdDataLoader";
	public static String DATALOADER_M_DiscountSchema_BY_UUID = "M_DiscountSchemaByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDiscountSchema.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_DiscountSchema_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_DiscountSchema_BY_UUID;
	}
}
