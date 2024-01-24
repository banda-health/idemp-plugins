package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MDunning;
import org.compiere.model.MDunningLevel;
import org.compiere.model.MDunningRun;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for C_DunningRun - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_DunningRunInput extends MDunningRun implements I_C_DunningRunInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Dunning;
	private ForeignEntityInput mC_DunningLevel;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_DunningRunInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MDunningRun(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
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
	 * Set Dunning.
	 *
	 * @param C_Dunning Dunning Rules for overdue invoices
	 */
	@JsonProperty("C_Dunning")
	public void setC_DunningInput(ForeignEntityInput C_Dunning) {
		this.mC_Dunning = C_Dunning;
		MDunning foreignEntity;
		if (get_ID() == 0 && C_Dunning != null &&
				(foreignEntity = new Query(getCtx(), "C_Dunning", "C_Dunning_UU=?", get_TrxName())
						.setParameters(C_Dunning.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Dunning_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Dunning.
	 *
	 * @return Dunning Rules for overdue invoices
	 */
	@JsonProperty("C_Dunning")
	public ForeignEntityInput C_Dunning() {
		return mC_Dunning;
	}

	/**
	 * Set Dunning Level.
	 *
	 * @param C_DunningLevel Dunning Level
	 */
	@JsonProperty("C_DunningLevel")
	public void setC_DunningLevelInput(ForeignEntityInput C_DunningLevel) {
		this.mC_DunningLevel = C_DunningLevel;
		MDunningLevel foreignEntity;
		if (get_ID() == 0 && C_DunningLevel != null &&
				(foreignEntity = new Query(getCtx(), "C_DunningLevel", "C_DunningLevel_UU=?", get_TrxName())
						.setParameters(C_DunningLevel.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_DunningLevel_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Dunning Level.
	 *
	 * @return Dunning Level
	 */
	@JsonProperty("C_DunningLevel")
	public ForeignEntityInput C_DunningLevel() {
		return mC_DunningLevel;
	}
	/**
	 * Set Dunning Run.
	 *
	 * @param C_DunningRun_ID Dunning Run
	 */

	public void setC_DunningRun_ID(int C_DunningRun_ID) {
		if (get_ID() == 0) {
			super.setC_DunningRun_ID(C_DunningRun_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_DunningRun_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_DunningRun_UU();
	}
}
