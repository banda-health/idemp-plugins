package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_M_SerNoCtl;
import org.compiere.util.Env;

/**
 * Generated Model for M_SerNoCtl - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_SerNoCtlInput extends X_M_SerNoCtl implements I_M_SerNoCtlInput {

	 private I_AD_OrgInput AD_Org;

	/**
	 * Standard constructor
	 */
	public X_M_SerNoCtlInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
	}

	/**
	 * Set BH_Locked.
	 *
	 * @param BH_Locked Determines whether a record is locked or not (must configure each field to enabled/disabled to read from this field)
	 */
	public void setBH_Locked(boolean BH_Locked) {
		set_Value(COLUMNNAME_BH_Locked, BH_Locked);
	}


	/**
	 * Get BH_Locked.
	 *
	 * @return Determines whether a record is locked or not (must configure each field to enabled/disabled to read from this field)
	 */
	public boolean isBH_Locked() {
 		Object columnValue = get_Value(COLUMNNAME_BH_Locked);
		if (columnValue != null) {
			if (columnValue instanceof Boolean) {
				return ((Boolean) columnValue);
			}
			return "Y".equals(columnValue);
		}
		return false;
	}

	/**
	 * Set Serial No Control.
	 *
	 * @param M_SerNoCtl_ID Product Serial Number Control
	 */

	public void setM_SerNoCtl_ID(int M_SerNoCtl_ID) {
		if (get_ID() == 0) {
			super.setM_SerNoCtl_ID(M_SerNoCtl_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_SerNoCtl_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_SerNoCtl_UU();
	}
}
