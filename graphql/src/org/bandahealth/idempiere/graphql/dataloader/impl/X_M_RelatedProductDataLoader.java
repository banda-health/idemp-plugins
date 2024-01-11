package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_M_RelatedProduct;

/**
 * Data Loader for M_RelatedProduct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_RelatedProductDataLoader extends PODataLoader<X_M_RelatedProduct> {
	public static String M_RelatedProduct_BY_ID_DATA_LOADER = "M_RelatedProductByIdDataLoader";
	public static String M_RelatedProduct_BY_UUID_DATA_LOADER = "M_RelatedProductByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_M_RelatedProduct.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_RelatedProduct_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_RelatedProduct_BY_UUID_DATA_LOADER;
	}
}
