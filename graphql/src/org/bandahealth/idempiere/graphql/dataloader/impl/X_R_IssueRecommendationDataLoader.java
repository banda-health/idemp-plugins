package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_R_IssueRecommendation;

/**
 * Data Loader for R_IssueRecommendation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_IssueRecommendationDataLoader extends PODataLoader<X_R_IssueRecommendation> {
	public static String R_IssueRecommendation_BY_ID_DATA_LOADER = "R_IssueRecommendationByIdDataLoader";
	public static String R_IssueRecommendation_BY_UUID_DATA_LOADER = "R_IssueRecommendationByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_R_IssueRecommendation.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return R_IssueRecommendation_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return R_IssueRecommendation_BY_UUID_DATA_LOADER;
	}
}
