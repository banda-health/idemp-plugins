package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.X_B_BidComment;

/**
 * Data Loader for B_BidComment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_B_BidCommentDataLoader extends PODataLoader<X_B_BidComment> {
	public static String B_BidComment_BY_ID_DATA_LOADER = "B_BidCommentByIdDataLoader";
	public static String B_BidComment_BY_UUID_DATA_LOADER = "B_BidCommentByUuidDataLoader";

	@Override
	protected String getTableName() {
		return X_B_BidComment.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return B_BidComment_BY_ID_DATA_LOADER;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return B_BidComment_BY_UUID_DATA_LOADER;
	}
}
