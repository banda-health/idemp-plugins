package org.bandahealth.idempiere.rest.service.db;

import java.sql.Timestamp;

import org.bandahealth.idempiere.base.model.MUser_BH;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Terms Of Service functionality.
 * 
 * @author andrew
 *
 */
public class TermsOfServiceService {

	/**
	 * Verify if the terms of service have been accepted.
	 * 
	 * @return
	 */
	public static boolean isAccepted() {
		String whereClause = MUser_BH.COLUMNNAME_AD_User_ID + "=" + Env.getAD_User_ID(Env.getCtx()) + " AND "
				+ MUser_BH.COLUMNNAME_BH_HasAcceptedTermsOfUse + "='Y'";
		return new Query(Env.getCtx(), MUser_BH.Table_Name, whereClause, null).setOnlyActiveRecords(true).match();
	}

	/**
	 * User accepts terms of service.
	 */
	public static boolean acceptTermsOfUse() {
		MUser_BH user = new MUser_BH(Env.getCtx(), Env.getAD_User_ID(Env.getCtx()), null);
		if (user != null) {
			user.setBH_HasAcceptedTermsOfUse(true);
			user.setBH_TOSDateAccepted(new Timestamp(System.currentTimeMillis()));
			user.save();

			return true;
		}

		return false;
	}
}
