package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDistributionLine;

/**
 * Data Loader for GL_DistributionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_GL_DistributionLineDataLoader extends PODataLoader<MDistributionLine> {
	public static String GL_DistributionLine_BY_ID_DATA_LOADER = "GL_DistributionLineByIdDataLoader";
	public static String GL_DistributionLine_BY_UUID_DATA_LOADER = "GL_DistributionLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDistributionLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return GL_DistributionLine_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return GL_DistributionLine_BY_UUID_DATA_LOADER;
	}
}
