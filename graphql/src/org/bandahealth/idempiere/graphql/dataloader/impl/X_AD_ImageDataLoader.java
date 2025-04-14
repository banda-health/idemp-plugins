package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MImage;

/**
 * Data Loader for AD_Image - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_ImageDataLoader extends PODataLoader<MImage> {
	public static String DATALOADER_AD_Image_BY_ID = "AD_ImageByIdDataLoader";
	public static String DATALOADER_AD_Image_BY_UUID = "AD_ImageByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MImage.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Image_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Image_BY_UUID;
	}
}
