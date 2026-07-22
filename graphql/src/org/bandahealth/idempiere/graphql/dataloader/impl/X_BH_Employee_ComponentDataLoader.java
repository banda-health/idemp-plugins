package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHEmployeeComponent;

/**
 * Data Loader for BH_Employee_Component - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Employee_ComponentDataLoader extends PODataLoader<MBHEmployeeComponent> {
	public static String DATALOADER_BH_Employee_Component_BY_ID = "BH_Employee_ComponentByIdDataLoader";
	public static String DATALOADER_BH_Employee_Component_BY_UUID = "BH_Employee_ComponentByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHEmployeeComponent.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_Employee_Component_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_Employee_Component_BY_UUID;
	}
}
