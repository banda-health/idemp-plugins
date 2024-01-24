package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRequisitionLine;

/**
 * Data Loader for M_RequisitionLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_RequisitionLineDataLoader extends PODataLoader<MRequisitionLine> {
	public static String DATALOADER_M_RequisitionLine_BY_ID = "M_RequisitionLineByIdDataLoader";
	public static String DATALOADER_M_RequisitionLine_BY_UUID = "M_RequisitionLineByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRequisitionLine.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_RequisitionLine_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_RequisitionLine_BY_UUID;
	}
}
