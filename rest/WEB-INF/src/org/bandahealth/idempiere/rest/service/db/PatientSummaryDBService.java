package org.bandahealth.idempiere.rest.service.db;

import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.rest.model.PatientSummary;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.springframework.stereotype.Component;

@Component
public class PatientSummaryDBService {

	public PatientSummary get(String period) {
		String whereClause = null;

		if (period.equalsIgnoreCase("today")) {
			whereClause = "to_char(" + MOrder_BH.COLUMNNAME_Created
					+ ", 'YYYY-MM-DD') = to_char(current_date, 'YYYY-MM-DD')";
		} else if (period.equalsIgnoreCase("this_week")) {
			whereClause = MOrder_BH.COLUMNNAME_Created + " BETWEEN date_trunc('week', current_date) and now()";
		} else if (period.equalsIgnoreCase("this_month")) {
			whereClause = MOrder_BH.COLUMNNAME_Created + " BETWEEN date_trunc('month', current_date) and now()";
		}

		// get total visits.
		int totalVisits = new Query(Env.getCtx(), MOrder_BH.Table_Name, whereClause, null).setOnlyActiveRecords(true)
				.setClient_ID().count();

		// get inpatients
		String patientTypeWhereClause = "";
		if (whereClause != null) {
			patientTypeWhereClause = whereClause + " AND ";
		}

		patientTypeWhereClause += "BH_PATIENTTYPE =?";

		// get inpatients
		int totalInpatients = new Query(Env.getCtx(), MOrder_BH.Table_Name, patientTypeWhereClause, null)
				.setOnlyActiveRecords(true).setParameters("I").setClient_ID().count();

		// get outpatients
		int totalOutpatients = new Query(Env.getCtx(), MOrder_BH.Table_Name, patientTypeWhereClause, null)
				.setOnlyActiveRecords(true).setParameters("O").setClient_ID().count();

		// get patients with open balances.
		String openBalanceWhereClause = "";
		if (whereClause != null) {
			openBalanceWhereClause = whereClause + " AND ";
		}

		openBalanceWhereClause += MBPartner_BH.COLUMNNAME_TotalOpenBalance + " > 0";

		int patientsWithOutstandingBalance = new Query(Env.getCtx(), MBPartner_BH.Table_Name, openBalanceWhereClause,
				null).setOnlyActiveRecords(true).setClient_ID().count();

		PatientSummary patientSummary = new PatientSummary(totalVisits, totalInpatients, totalOutpatients,
				patientsWithOutstandingBalance);
		patientSummary.setIsActive(true);
		patientSummary.setClientId(Env.getAD_Client_ID(Env.getCtx()));
		patientSummary.setOrgId(Env.getAD_Org_ID(Env.getCtx()));

		return patientSummary;
	}
}
