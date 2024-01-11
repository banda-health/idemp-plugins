package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDistribution;

/**
 * Data Loader for GL_Distribution - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_GL_DistributionDataLoader extends PODataLoader<MDistribution> {
	public static String GL_Distribution_BY_ID_DATA_LOADER = "GL_DistributionByIdDataLoader";
	public static String GL_Distribution_BY_UUID_DATA_LOADER = "GL_DistributionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDistribution.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return GL_Distribution_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return GL_Distribution_BY_UUID_DATA_LOADER;
	}
}
