package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_PA_RatioElement;

/**
 * Data Loader for PA_RatioElement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_RatioElementDataLoader extends PODataLoader<X_PA_RatioElement> {
	public static String PA_RatioElement_BY_ID_DATA_LOADER = "PA_RatioElementByIdDataLoader";
	public static String PA_RatioElement_BY_UUID_DATA_LOADER = "PA_RatioElementByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_PA_RatioElement.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return PA_RatioElement_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return PA_RatioElement_BY_UUID_DATA_LOADER;
	}
}
