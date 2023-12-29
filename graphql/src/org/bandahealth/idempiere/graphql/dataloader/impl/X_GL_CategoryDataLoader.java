package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MGLCategory;

/**
 * Data Loader for GL_Category - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_GL_CategoryDataLoader extends PODataLoader<MGLCategory> {
	public static String GL_Category_BY_ID_DATA_LOADER = "GL_CategoryByIdDataLoader";
	public static String GL_Category_BY_UUID_DATA_LOADER = "GL_CategoryByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MGLCategory.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return GL_Category_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return GL_Category_BY_UUID_DATA_LOADER;
	}
}
