package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_R_IssueRecommendation;

/**
 * Data Loader for R_IssueRecommendation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_R_IssueRecommendationDataLoader extends PODataLoader<X_R_IssueRecommendation> {
	public static String DATALOADER_R_IssueRecommendation_BY_ID = "R_IssueRecommendationByIdDataLoader";
	public static String DATALOADER_R_IssueRecommendation_BY_UUID = "R_IssueRecommendationByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_R_IssueRecommendation.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_R_IssueRecommendation_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_R_IssueRecommendation_BY_UUID;
	}
}
