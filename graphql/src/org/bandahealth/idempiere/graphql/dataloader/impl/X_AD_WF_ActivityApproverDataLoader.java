package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MWFActivityApprover;

/**
 * Data Loader for AD_WF_ActivityApprover - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_WF_ActivityApproverDataLoader extends PODataLoader<MWFActivityApprover> {
	public static String AD_WF_ActivityApprover_BY_ID_DATA_LOADER = "AD_WF_ActivityApproverByIdDataLoader";
	public static String AD_WF_ActivityApprover_BY_UUID_DATA_LOADER = "AD_WF_ActivityApproverByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MWFActivityApprover.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return AD_WF_ActivityApprover_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return AD_WF_ActivityApprover_BY_UUID_DATA_LOADER;
	}
}
