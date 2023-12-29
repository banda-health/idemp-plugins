package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MLocation;
import org.compiere.model.MOrg;
import org.compiere.model.MSalesRegion;
import org.compiere.model.Query;
import org.compiere.model.X_C_BPartner_Location;
import org.compiere.util.Env;

/**
 * Generated Model for C_BPartner_Location - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BPartner_LocationInput extends X_C_BPartner_Location implements I_C_BPartner_LocationInput {

	 private I_AD_OrgInput AD_Org;
	 private I_C_BPartnerInput C_BPartner;
	 private I_C_LocationInput C_Location;
	 private I_C_SalesRegionInput C_SalesRegion;

	/**
	 * Standard constructor
	 */
	public X_C_BPartner_LocationInput(String ID) {
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
	 * Set Business Partner .
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	public void setC_BPartner(I_C_BPartnerInput C_BPartner) {
		this.C_BPartner = C_BPartner;
		MBPartner_BH foreignEntity;
		if (get_ID() == 0 &&C_BPartner != null &&
				(foreignEntity = new Query(getCtx(), MBPartner_BH.Table_Name, MBPartner_BH.COLUMNNAME_C_BPartner_UU + "=?", get_TrxName())
						.setParameters(C_BPartner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_BPartner_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	public I_C_BPartnerInput getC_BPartner() {
		return C_BPartner;
	}
	/**
	 * Set Business Partner .
	 *
	 * @param C_BPartner_ID Identifies a Business Partner
	 */

	public void setC_BPartner_ID(int C_BPartner_ID) {
		if (get_ID() == 0) {
			super.setC_BPartner_ID(C_BPartner_ID);
		}
	}
	/**
	 * Set Partner Location.
	 *
	 * @param C_BPartner_Location_ID Identifies the (ship to) address for this Business Partner
	 */

	public void setC_BPartner_Location_ID(int C_BPartner_Location_ID) {
		if (get_ID() == 0) {
			super.setC_BPartner_Location_ID(C_BPartner_Location_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_BPartner_Location_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_BPartner_Location_UU();
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

	/**
	 * Set Sales Region.
	 *
	 * @param C_SalesRegion Sales coverage region
	 */
	public void setC_SalesRegion(I_C_SalesRegionInput C_SalesRegion) {
		this.C_SalesRegion = C_SalesRegion;
		MSalesRegion foreignEntity;
		if (C_SalesRegion != null &&
				(foreignEntity = new Query(getCtx(), MSalesRegion.Table_Name, MSalesRegion.COLUMNNAME_C_SalesRegion_UU + "=?", get_TrxName())
						.setParameters(C_SalesRegion.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_SalesRegion_ID(foreignEntity.get_ID());
		} else {
			this.setC_SalesRegion_ID(0);
		}
	}

	/**
	 * Get Sales Region.
	 *
	 * @return Sales coverage region
	 */
	public I_C_SalesRegionInput getC_SalesRegion() {
		return C_SalesRegion;
	}
	/**
	 * Set Sales Region.
	 *
	 * @param C_SalesRegion_ID Sales coverage region
	 */

	public void setC_SalesRegion_ID(int C_SalesRegion_ID) {
		if (get_ID() == 0) {
			super.setC_SalesRegion_ID(C_SalesRegion_ID);
		}
	}
}
