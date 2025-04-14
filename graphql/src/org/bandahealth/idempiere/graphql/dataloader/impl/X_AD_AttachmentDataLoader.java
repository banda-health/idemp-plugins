package org.bandahealth.idempiere.graphql.dataloader.impl;

import org.compiere.model.MAttachment;

/**
 * Data Loader for AD_Attachment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_AttachmentDataLoader extends PODataLoader<MAttachment> {
	public static String DATALOADER_AD_Attachment_BY_ID = "AD_AttachmentByIdDataLoader";
	public static String DATALOADER_AD_Attachment_BY_UUID = "AD_AttachmentByUuidDataLoader";

	@Override
	protected String getTableName() {
		return MAttachment.Table_Name;
	}

	@Override
	protected String getByIdDataLoaderName() {
		return DATALOADER_AD_Attachment_BY_ID;
	}

	@Override
	protected String getByUuidDataLoaderName() {
		return DATALOADER_AD_Attachment_BY_UUID;
	}
}
