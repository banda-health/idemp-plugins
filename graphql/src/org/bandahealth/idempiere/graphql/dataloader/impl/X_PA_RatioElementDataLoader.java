package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_PA_RatioElement;

/**
 * Data Loader for PA_RatioElement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_RatioElementDataLoader extends PODataLoader<X_PA_RatioElement> {
	public static String DATALOADER_PA_RatioElement_BY_ID = "PA_RatioElementByIdDataLoader";
	public static String DATALOADER_PA_RatioElement_BY_UUID = "PA_RatioElementByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_PA_RatioElement.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_PA_RatioElement_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_PA_RatioElement_BY_UUID;
	}
}
