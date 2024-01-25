package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MInOutLineConfirm;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_I_InOutLineConfirm;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for I_InOutLineConfirm - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_I_InOutLineConfirmInput extends X_I_InOutLineConfirm implements I_I_InOutLineConfirmInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_InOutLineConfirm;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The I_InOutLineConfirm_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_I_InOutLineConfirmInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_I_InOutLineConfirm(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
		} else {
			this.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}
	/**
	 * Set Ship/Receipt Confirmation Import Line.
	 *
	 * @param I_InOutLineConfirm_ID Material Shipment or Receipt Confirmation Import Line
	 */

	public void setI_InOutLineConfirm_ID(int I_InOutLineConfirm_ID) {
		if (get_ID() == 0) {
			super.setI_InOutLineConfirm_ID(I_InOutLineConfirm_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setI_InOutLineConfirm_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getI_InOutLineConfirm_UU();
	}

	/**
	 * Set Ship/Receipt Confirmation Line.
	 *
	 * @param M_InOutLineConfirm Material Shipment or Receipt Confirmation Line
	 */
	@JsonProperty("M_InOutLineConfirm")
	public void setM_InOutLineConfirmInput(ForeignEntityInput M_InOutLineConfirm) {
		this.mM_InOutLineConfirm = M_InOutLineConfirm;
		if (M_InOutLineConfirm != null) {
			// Since an entity was passed, make sure it's in the DB
			MInOutLineConfirm foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_InOutLineConfirm", "M_InOutLineConfirm_UU=?", get_TrxName())
							.setParameters(M_InOutLineConfirm.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_InOutLineConfirm_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_InOutLineConfirm with UUID " + M_InOutLineConfirm.getUUID());
			}
		} else {
			this.setM_InOutLineConfirm_ID(0);
		}
	}

	/**
	 * Get Ship/Receipt Confirmation Line.
	 *
	 * @return Material Shipment or Receipt Confirmation Line
	 */
	@JsonProperty("M_InOutLineConfirm")
	public ForeignEntityInput M_InOutLineConfirm() {
		return mM_InOutLineConfirm;
	}
}
