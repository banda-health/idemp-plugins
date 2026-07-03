package org.bandahealth.idempiere.base.process;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.CacheMgt;
import org.compiere.util.DB;

import java.util.logging.Level;

/**
 * Self-service clinic (client) rename. Renames the current client (taken from the iDempiere context)
 * and cascades the new name to every display name derived from it (the org, the clinic-named warehouse,
 * and the prefixed role and tree names) by calling the reusable {@code bh_rename_client()} DB function,
 * then resets the cache so the running application reflects the new names without a server restart.
 * <p>
 * The process runs in the current client's context (Client+Organization access), so the clinic to rename
 * is the current client - no target parameter is needed. Access is restricted via AD_Process_Access
 * (granted only to the System Administrator and Implementer roles). The run is audited automatically
 * through AD_PInstance (who ran it, when, and the new name).
 */
public class RenameClientProcess extends SvrProcess {
	public static final String PARAMETERNAME_NEW_NAME = "BH_NewClinicName";

	private String newName;

	@Override
	protected void prepare() {
		for (ProcessInfoParameter parameter : getParameter()) {
			String parameterName = parameter.getParameterName();
			if (PARAMETERNAME_NEW_NAME.equalsIgnoreCase(parameterName)) {
				newName = parameter.getParameterAsString();
			} else {
				log.log(Level.SEVERE, "Unknown Parameter: " + parameterName);
			}
		}
	}

	@Override
	protected String doIt() throws Exception {
		if (newName == null || newName.trim().isEmpty()) {
			throw new AdempiereException("New clinic name must not be blank");
		}

		// The clinic to rename is the current client from the iDempiere context.
		int adClientId = getAD_Client_ID();
		if (adClientId <= 0) {
			throw new AdempiereException("Clinic rename must be run from within a client's workspace");
		}

		// Run the cascade inside this process's transaction so it commits/rolls back atomically.
		// getSQLValueStringEx throws (rather than swallowing) so the function's guard messages surface to the user.
		String summary = DB.getSQLValueStringEx(get_TrxName(), "SELECT bh_rename_client(?, ?, ?)",
				adClientId, newName.trim(), getAD_User_ID());
		if (summary == null) {
			throw new AdempiereException("Clinic rename failed - no result returned");
		}

		// addLog so the summary reaches callers via ProcessInfo.getLogInfo() - the GraphQL run-process
		// resolver returns getLogInfo(), not the doIt() return value (which only sets getSummary()).
		addLog(summary);

		// Reset caches so client/org/role/warehouse names refresh without a server restart.
		// Users with active sessions must re-login to see renamed role names.
		// NOTE: this runs before the managed process transaction commits, so there is a small window
		// where a concurrent session could re-cache the old names; acceptable for this admin-only action.
		CacheMgt.get().reset();

		log.log(Level.INFO, summary);
		return summary;
	}
}
