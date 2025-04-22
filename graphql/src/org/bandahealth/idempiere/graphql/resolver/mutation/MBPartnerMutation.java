package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.schema.DataFetchingEnvironment;
import org.adempiere.exceptions.DBException;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MUser;
import org.compiere.model.PO;
import org.compiere.util.CPreparedStatement;
import org.compiere.util.DB;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MBPartnerMutation extends X_C_BPartnerMutation {

	public Boolean C_BPartnerMerge(String OldUU, String NewUU, DataFetchingEnvironment environment) {
		try {
			// Security checks
			ModelUtil.getTableAndCheckAccess(BandaGraphQLContext.getCtx(environment), MBPartner_BH.Table_Name, true);
			Map<String, PO> businessPartnersByUU =
					Repository.getByUuids(BandaGraphQLContext.getCtx(environment), MBPartner_BH.Table_Name, null,
							Set.of(OldUU, NewUU));
			if (businessPartnersByUU.get(OldUU).getAD_Client_ID() != businessPartnersByUU.get(NewUU).getAD_Client_ID()) {
				return false;
			}

			// First merge contacts
			MUser[] oldContacts = ((MBPartner_BH) businessPartnersByUU.get(OldUU)).getContacts(false);
			MUser[] newContacts = ((MBPartner_BH) businessPartnersByUU.get(NewUU)).getContacts(false);
			//
			for (MUser oldContact : oldContacts) {
				try (CPreparedStatement statement = DB.prepareStatement("SELECT bh_merge_records(?, ?::uuid, ?::uuid)",
						null)) {
					DB.setParameters(statement,
							List.of(MUser_BH.Table_Name, oldContact.getAD_User_UU(), newContacts[0].getAD_User_UU()).toArray());
					statement.execute();
				}
			}

			// Next, merge locations
			MBPartnerLocation[] oldLocations = ((MBPartner_BH) businessPartnersByUU.get(OldUU)).getLocations(false);
			MBPartnerLocation[] newLocations = ((MBPartner_BH) businessPartnersByUU.get(NewUU)).getLocations(false);
			//
			for (MBPartnerLocation oldLocation : oldLocations) {
				try (CPreparedStatement statement = DB.prepareStatement("SELECT bh_merge_records(?, ?::uuid, ?::uuid)",
						null)) {
					DB.setParameters(statement, List.of(MBPartnerLocation.Table_Name, oldLocation.getC_BPartner_Location_UU(),
							newLocations[0].getC_BPartner_Location_UU()).toArray());
					statement.execute();
				}
			}

			// Now merge the actual business partners
			try (CPreparedStatement statement = DB.prepareStatement("SELECT bh_merge_records(?, ?::uuid, ?::uuid)", null)) {
				DB.setParameters(statement, List.of(MBPartner_BH.Table_Name, OldUU, NewUU).toArray());
				statement.execute();
			}
			return true;
		} catch (DBException | SQLException e) {
			log.severe(e.getMessage());
		}
		return false;
	}
}
