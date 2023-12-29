package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MImage;

/**
 * Data Loader for AD_Image - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_ImageDataLoader extends PODataLoader<MImage> {
	public static String AD_Image_BY_ID_DATA_LOADER = "AD_ImageByIdDataLoader";
	public static String AD_Image_BY_UUID_DATA_LOADER = "AD_ImageByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MImage.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_Image_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_Image_BY_UUID_DATA_LOADER;
	}
}
