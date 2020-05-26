package org.bandahealth.idempiere.base.process;

import org.adempiere.exceptions.AdempiereException;
import org.adempiere.process.InitialClientSetup;
import org.bandahealth.idempiere.base.model.MBandaSetup;
import org.compiere.model.MSetup;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.util.Env;
import org.compiere.util.Msg;

/**
 * Process to extend the Initial iDempiere client setup with Banda stuff
 */
public class InitialBandaClientSetup extends InitialClientSetup {

	private boolean wantsCashBoxAccount;
	private boolean wantsMobileAccount;
	private boolean wantsSavingsAccount;

	/**
	 * Prepare
	 */
	protected void prepare() {
		super.prepare();

		ProcessInfoParameter[] para = getParameter();
		for (int i = 0; i < para.length; i++) {
			String name = para[i].getParameterName();
			if (para[i].getParameter() == null) {
				;
			} else if (name.equals("IsUsingCashBox")) {
				wantsCashBoxAccount = para[i].getParameterAsBoolean();
			} else if (name.equals("IsUsingMobile")) {
				wantsMobileAccount = para[i].getParameterAsBoolean();
			} else if (name.equals("IsUsingSavings")) {
				wantsSavingsAccount = para[i].getParameterAsBoolean();
			}
		}
	}

	/**
	 * 	Process
	 *	@return info
	 *	@throws Exception
	 */
	protected String doIt() throws Exception {
		String completeInfo = super.doIt();

		// Get the setup that the
		MSetup setup = new MSetup(Env.getCtx(), InitialClientSetup.WINDOW_THIS_PROCESS);
		MBandaSetup bandaSetup = new MBandaSetup(setup, Env.getCtx(), InitialClientSetup.WINDOW_THIS_PROCESS);
		if (bandaSetup.getAccountSchema() == null) {
			bandaSetup.rollback();
			throw new AdempiereException("@" + Msg.getMsg(Env.getCtx(), "AccountSetupError")+ "@");
		}
		try {
			if (!bandaSetup.createBankAccounts(wantsCashBoxAccount, wantsMobileAccount, wantsSavingsAccount)) {
				bandaSetup.rollback();
				throw new AdempiereException("@" + Msg.getMsg(Env.getCtx(), "AccountSetupError")+ "@");
			}
		} catch (Exception e) {
			bandaSetup.rollback();
			throw e;
		}

		return completeInfo;
	}
}
