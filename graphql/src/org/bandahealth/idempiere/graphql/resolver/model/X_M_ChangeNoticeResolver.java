package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.compiere.model.MChangeNotice;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for M_ChangeNotice - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_ChangeNoticeResolver extends POResolver<MChangeNotice> implements GraphQLResolver<MChangeNotice> {


	public Boolean IsApproved(MChangeNotice entity, DataFetchingEnvironment environment) {
		return entity.isApproved();
	}

	public Boolean Processed(MChangeNotice entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(MChangeNotice entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

}
