package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MRequisition;

/**
 * Data Loader for M_Requisition - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_RequisitionDataLoader extends PODataLoader<MRequisition> {
	public static String DATALOADER_M_Requisition_BY_ID = "M_RequisitionByIdDataLoader";
	public static String DATALOADER_M_Requisition_BY_UUID = "M_RequisitionByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MRequisition.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_Requisition_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_Requisition_BY_UUID;
	}
}
