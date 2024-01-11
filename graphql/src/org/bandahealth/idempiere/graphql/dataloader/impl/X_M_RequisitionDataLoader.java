package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRequisition;

/**
 * Data Loader for M_Requisition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_RequisitionDataLoader extends PODataLoader<MRequisition> {
	public static String M_Requisition_BY_ID_DATA_LOADER = "M_RequisitionByIdDataLoader";
	public static String M_Requisition_BY_UUID_DATA_LOADER = "M_RequisitionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRequisition.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return M_Requisition_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return M_Requisition_BY_UUID_DATA_LOADER;
	}
}
