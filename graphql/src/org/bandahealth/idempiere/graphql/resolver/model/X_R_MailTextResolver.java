package org.bandahealth.idempiere.graphql.resolver.model;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.compiere.model.MMailText;
import org.dataloader.DataLoader;

/**
 * Generated ModelResolver for R_MailText - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_R_MailTextResolver extends POResolver<MMailText> implements GraphQLResolver<MMailText> {


	public Boolean IsHtml(MMailText entity, DataFetchingEnvironment environment) {
		return entity.isHtml();
	}

}
