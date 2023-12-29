package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MBank;
import org.compiere.model.MLocation;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for C_Bank - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BankInput extends MBank implements I_C_BankInput {

	 private I_AD_OrgInput AD_Org;
	 private I_C_LocationInput C_Location;

	/**
	 * Standard constructor
	 */
	public X_C_BankInput(String ID) {
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_Bank_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_Bank_UU();
	}

	/**
	 * Set Address.
	 *
	 * @param C_Location Location or Address
	 */
	public void setC_Location(I_C_LocationInput C_Location) {
		this.C_Location = C_Location;
		MLocation foreignEntity;
		if (C_Location != null &&
				(foreignEntity = new Query(getCtx(), MLocation.Table_Name, MLocation.COLUMNNAME_C_Location_UU + "=?", get_TrxName())
						.setParameters(C_Location.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Location_ID(foreignEntity.get_ID());
		} else {
			this.setC_Location_ID(0);
		}
	}

	/**
	 * Get Address.
	 *
	 * @return Location or Address
	 */
	public I_C_LocationInput getC_Location() {
		return C_Location;
	}
}
