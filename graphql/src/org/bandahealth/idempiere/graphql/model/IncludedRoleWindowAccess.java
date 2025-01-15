package org.bandahealth.idempiere.graphql.model;

public class IncludedRoleWindowAccess {
	private Boolean canDeactivate;
	private Integer windowId;
	private Boolean isReadWrite;

	/**
	 * Set Window.
	 *
	 * @param AD_Window_ID Data entry or display window
	 */
	public void setAD_Window_ID(int AD_Window_ID) {
		if (AD_Window_ID < 1) {
			windowId = null;
		} else {
			windowId = AD_Window_ID;
		}
	}

	/**
	 * Get Window.
	 *
	 * @return Data entry or display window
	 */
	public int getAD_Window_ID() {
		if (windowId == null) {
			return 0;
		}
		return windowId;
	}

	/**
	 * Set Can Deactivate.
	 *
	 * @param BH_CanDeactivate Can Deactivate
	 */
	public void setBH_CanDeactivate(boolean BH_CanDeactivate) {
		canDeactivate = BH_CanDeactivate;
	}

	/**
	 * Get Can Deactivate.
	 *
	 * @return Can Deactivate
	 */
	public boolean isBH_CanDeactivate() {
		if (canDeactivate != null) {
			return canDeactivate;
		}
		return false;
	}

	/**
	 * Set Read Write.
	 *
	 * @param IsReadWrite Field is read / write
	 */
	public void setIsReadWrite(boolean IsReadWrite) {
		isReadWrite = IsReadWrite;
	}

	/**
	 * Get Read Write.
	 *
	 * @return Field is read / write
	 */
	public boolean isReadWrite() {
		if (isReadWrite != null) {
			return isReadWrite;
		}
		return false;
	}
}
