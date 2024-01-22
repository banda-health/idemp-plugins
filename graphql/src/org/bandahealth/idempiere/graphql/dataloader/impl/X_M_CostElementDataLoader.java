package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MCostElement;

/**
 * Data Loader for M_CostElement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_CostElementDataLoader extends PODataLoader<MCostElement> {
	public static String DATALOADER_M_CostElement_BY_ID = "M_CostElementByIdDataLoader";
	public static String DATALOADER_M_CostElement_BY_UUID = "M_CostElementByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MCostElement.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_M_CostElement_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_M_CostElement_BY_UUID;
	}
}
