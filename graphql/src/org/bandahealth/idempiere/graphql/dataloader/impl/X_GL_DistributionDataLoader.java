package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDistribution;

/**
 * Data Loader for GL_Distribution - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_GL_DistributionDataLoader extends PODataLoader<MDistribution> {
	public static String DATALOADER_GL_Distribution_BY_ID = "GL_DistributionByIdDataLoader";
	public static String DATALOADER_GL_Distribution_BY_UUID = "GL_DistributionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDistribution.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_GL_Distribution_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_GL_Distribution_BY_UUID;
	}
}
