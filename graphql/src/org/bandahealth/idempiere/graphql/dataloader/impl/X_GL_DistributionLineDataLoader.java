package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MDistributionLine;

/**
 * Data Loader for GL_DistributionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_GL_DistributionLineDataLoader extends PODataLoader<MDistributionLine> {
	public static String DATALOADER_GL_DistributionLine_BY_ID = "GL_DistributionLineByIdDataLoader";
	public static String DATALOADER_GL_DistributionLine_BY_UUID = "GL_DistributionLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MDistributionLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_GL_DistributionLine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_GL_DistributionLine_BY_UUID;
	}
}
