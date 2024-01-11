package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRequisitionLine;

/**
 * Data Loader for M_RequisitionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_RequisitionLineDataLoader extends PODataLoader<MRequisitionLine> {
	public static String M_RequisitionLine_BY_ID_DATA_LOADER = "M_RequisitionLineByIdDataLoader";
	public static String M_RequisitionLine_BY_UUID_DATA_LOADER = "M_RequisitionLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRequisitionLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_RequisitionLine_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_RequisitionLine_BY_UUID_DATA_LOADER;
	}
}
