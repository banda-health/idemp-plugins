package org.bandahealth.idempiere.base.process;

import org.adempiere.process.InitialClientSetup;

/**
 * Process to extend the Initial iDempiere client setup with Banda stuff
 */
public class InitialBandaClientSetup extends InitialClientSetup {

	/**
	 * Prepare
	 */
	protected void prepare() {
		super.prepare();
	}

	/**
	 * 	Process
	 *	@return info
	 *	@throws Exception
	 */
	protected String doIt() throws Exception {
		String completeInfo = super.doIt();

		return completeInfo;
	}
}
