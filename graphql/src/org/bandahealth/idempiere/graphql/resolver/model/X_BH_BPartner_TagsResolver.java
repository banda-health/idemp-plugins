package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHBPartnerTags;
import org.bandahealth.idempiere.base.model.MBHTag;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_TagDataLoader;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_BPartnerDataLoader;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated ModelResolver for BH_BPartner_Tags - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_BPartner_TagsResolver extends POResolver<MBHBPartnerTags> implements GraphQLResolver<MBHBPartnerTags> {



	/**
	 * Get BH Tag.
	 *
	 * @return BH Tag
	 */
	public CompletableFuture<MBHTag> BH_Tag(MBHBPartnerTags entity, DataFetchingEnvironment environment) {
		if (entity.getBH_Tag_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBHTag> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_BH_TagDataLoader.DATALOADER_BH_Tag_BY_ID);
		return dataLoader.load(entity.getBH_Tag_ID());
	}


	/**
	 * Get Business Partner.
	 *
	 * @return Identifies a Business Partner
	 */
	public CompletableFuture<MBPartner_BH> C_BPartner(MBHBPartnerTags entity, DataFetchingEnvironment environment) {
		if (entity.getC_BPartner_ID() < 1) {
			return null;
		}
		DataLoader<Integer, MBPartner_BH> dataLoader =
				environment.getDataLoaderRegistry().getDataLoader(X_C_BPartnerDataLoader.DATALOADER_C_BPartner_BY_ID);
		return dataLoader.load(entity.getC_BPartner_ID());
	}

}
