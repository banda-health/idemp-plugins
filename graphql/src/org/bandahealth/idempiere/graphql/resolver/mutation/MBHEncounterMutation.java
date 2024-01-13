package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.schema.DataFetchingEnvironment;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHEncounter;
import org.bandahealth.idempiere.base.model.MBHEncounterDiagnosis;
import org.bandahealth.idempiere.base.model.MBHObservation;
import org.bandahealth.idempiere.graphql.context.BandaGraphQLContext;
import org.bandahealth.idempiere.graphql.repository.Repository;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.compiere.util.Trx;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class MBHEncounterMutation extends X_BH_EncounterMutation {
	@Override
	protected boolean delete(List<String> uuids, DataFetchingEnvironment environment) {
		Map<String, MBHEncounter> entitiesByUuid =
				Repository.getByUuids(BandaGraphQLContext.getCtx(environment), getTableName(), null, new HashSet<>(uuids));

		for (MBHEncounter entity : entitiesByUuid.values()) {
			Trx deleteEncounterTransaction = Trx.get(Trx.createTrxName("DeleteEncounter"), true);
			try {
				entity.set_TrxName(deleteEncounterTransaction.getTrxName());

				List<MBHEncounterDiagnosis> mEncounterDiagnoses = new Query(Env.getCtx(), MBHEncounterDiagnosis.Table_Name,
						MBHEncounterDiagnosis.COLUMNNAME_BH_Encounter_ID + " =?", deleteEncounterTransaction.getTrxName())
						.setParameters(entity.getBH_Encounter_ID()).setClient_ID().list();

				for (MBHEncounterDiagnosis mEncounterDiagnosis : mEncounterDiagnoses) {
					mEncounterDiagnosis.deleteEx(false);
				}

				List<MBHObservation> mObservations = new Query(Env.getCtx(), MBHObservation.Table_Name,
						MBHObservation.COLUMNNAME_BH_Encounter_ID + " =?", deleteEncounterTransaction.getTrxName())
						.setParameters(entity.getBH_Encounter_ID()).setClient_ID().list();

				for (MBHObservation mObservation : mObservations) {
					mObservation.deleteEx(false);
				}

				boolean didDelete = entity.delete(true);
				if (!deleteEncounterTransaction.commit(true)) {
					log.severe("Could not commit encounter transaction");
					return false;
				}

				return didDelete;
			} catch (Exception ex) {
				try {
					if (!deleteEncounterTransaction.rollback(true)) {
						log.severe("Could not roll back encounter transaction");
					}
				} catch (SQLException e) {
					log.severe("Could not roll back encounter transaction: " + e.getLocalizedMessage());
				}
				throw new AdempiereException(ex.getLocalizedMessage());
			} finally {
				if (!deleteEncounterTransaction.close()) {
					log.severe("Could not close encounter transaction");
					return false;
				}
			}
		}

		return true;
	}
}
