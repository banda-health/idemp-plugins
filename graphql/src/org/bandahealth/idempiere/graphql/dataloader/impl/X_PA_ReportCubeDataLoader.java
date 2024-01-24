package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MReportCube;

/**
 * Data Loader for PA_ReportCube - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_ReportCubeDataLoader extends PODataLoader<MReportCube> {
	public static String DATALOADER_PA_ReportCube_BY_ID = "PA_ReportCubeByIdDataLoader";
	public static String DATALOADER_PA_ReportCube_BY_UUID = "PA_ReportCubeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MReportCube.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_PA_ReportCube_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_PA_ReportCube_BY_UUID;
	}
}
