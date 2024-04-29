package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MSerNoCtl_BH;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for M_SerNoCtl - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_SerNoCtlResolver extends POResolver<MSerNoCtl_BH> implements GraphQLResolver<MSerNoCtl_BH> {


	public Boolean BH_Locked(MSerNoCtl_BH entity, DataFetchingEnvironment environment) {
		return entity.isBH_Locked();
	}

}
