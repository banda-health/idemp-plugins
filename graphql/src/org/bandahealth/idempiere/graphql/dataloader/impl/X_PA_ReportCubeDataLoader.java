package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MReportCube;

/**
 * Data Loader for PA_ReportCube - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_ReportCubeDataLoader extends PODataLoader<MReportCube> {
	public static String PA_ReportCube_BY_ID_DATA_LOADER = "PA_ReportCubeByIdDataLoader";
	public static String PA_ReportCube_BY_UUID_DATA_LOADER = "PA_ReportCubeByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MReportCube.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return PA_ReportCube_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return PA_ReportCube_BY_UUID_DATA_LOADER;
	}
}
