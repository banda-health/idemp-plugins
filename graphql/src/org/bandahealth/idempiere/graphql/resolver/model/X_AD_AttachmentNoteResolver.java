package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_AttachmentDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_UserDataLoader;
import org.compiere.model.MAttachment;
import org.compiere.model.MAttachmentNote;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for AD_AttachmentNote - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_AttachmentNoteResolver extends POResolver<MAttachmentNote> implements GraphQLResolver<MAttachmentNote> {



	/**
	 * Get Attachment.
	 *
	 * @return Attachment for the document
	 */
	public CompletableFuture<MAttachment> AD_Attachment(MAttachmentNote entity, DataFetchingEnvironment environment) {
		if (entity.getAD_Attachment_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MAttachment> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_AttachmentDataLoader.DATALOADER_AD_Attachment_BY_ID);
		return dataLoader.load(entity.getAD_Attachment_ID());
	}


	/**
	 * Get User/Contact.
	 *
	 * @return User within the system - Internal or Business Partner Contact
	 */
	public CompletableFuture<MUser_BH> AD_User(MAttachmentNote entity, DataFetchingEnvironment environment) {
		if (entity.getAD_User_ID() < 0) {
			return null;
		}
		DataLoader<Integer, MUser_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_AD_UserDataLoader.DATALOADER_AD_User_BY_ID);
		return dataLoader.load(entity.getAD_User_ID());
	}

}
