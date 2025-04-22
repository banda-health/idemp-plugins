package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MGLCategory;

/**
 * Data Loader for GL_Category - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_GL_CategoryDataLoader extends PODataLoader<MGLCategory> {
	public static String DATALOADER_GL_Category_BY_ID = "GL_CategoryByIdDataLoader";
	public static String DATALOADER_GL_Category_BY_UUID = "GL_CategoryByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MGLCategory.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_GL_Category_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_GL_Category_BY_UUID;
	}
}
