package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.compiere.model.X_AD_Package_Imp_Inst;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for AD_Package_Imp_Inst - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_Package_Imp_InstResolver extends POResolver<X_AD_Package_Imp_Inst> implements GraphQLResolver<X_AD_Package_Imp_Inst> {


	public Boolean Processed(X_AD_Package_Imp_Inst entity, DataFetchingEnvironment environment) {
		return entity.isProcessed();
	}

	public Boolean Processing(X_AD_Package_Imp_Inst entity, DataFetchingEnvironment environment) {
		return entity.isProcessing();
	}

	public Boolean Uninstall(X_AD_Package_Imp_Inst entity, DataFetchingEnvironment environment) {
		return entity.isUninstall();
	}

}
