package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MBPartnerProduct;

/**
 * Data Loader for C_BPartner_Product - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_BPartner_ProductDataLoader extends PODataLoader<MBPartnerProduct> {
	public static String DATALOADER_C_BPartner_Product_BY_ID = "C_BPartner_ProductByIdDataLoader";
	public static String DATALOADER_C_BPartner_Product_BY_UUID = "C_BPartner_ProductByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBPartnerProduct.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_C_BPartner_Product_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_C_BPartner_Product_BY_UUID;
	}
}
