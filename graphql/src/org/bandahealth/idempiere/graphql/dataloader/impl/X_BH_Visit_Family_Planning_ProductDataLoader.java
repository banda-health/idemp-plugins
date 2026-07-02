package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.bandahealth.idempiere.base.model.MBHVisitFamilyPlanningProduct;

/**
 * Data Loader for BH_Visit_Family_Planning_Product - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Visit_Family_Planning_ProductDataLoader extends PODataLoader<MBHVisitFamilyPlanningProduct> {
	public static String DATALOADER_BH_Visit_Family_Planning_Product_BY_ID = "BH_Visit_Family_Planning_ProductByIdDataLoader";
	public static String DATALOADER_BH_Visit_Family_Planning_Product_BY_UUID = "BH_Visit_Family_Planning_ProductByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MBHVisitFamilyPlanningProduct.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_BH_Visit_Family_Planning_Product_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_BH_Visit_Family_Planning_Product_BY_UUID;
	}
}
