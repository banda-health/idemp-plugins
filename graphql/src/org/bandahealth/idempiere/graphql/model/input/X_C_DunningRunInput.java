package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MDunning;
import org.compiere.model.MDunningLevel;
import org.compiere.model.MDunningRun;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_DunningRun - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_DunningRunInput extends MDunningRun implements I_C_DunningRunInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Dunning;
	private ForeignEntityInput mC_DunningLevel;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_DunningRun_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_DunningRunInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
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
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
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
	 * Set Dunning.
	 *
	 * @param C_Dunning Dunning Rules for overdue invoices
	 */
	@JsonProperty("C_Dunning")
	public void setC_DunningInput(ForeignEntityInput C_Dunning) {
		this.mC_Dunning = C_Dunning;
		if (get_ID() != 0) {
			return;
		}
		if (C_Dunning != null) {
			// Since an entity was passed, make sure it's in the DB
			MDunning foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Dunning", "C_Dunning_UU=?", get_TrxName())
							.setParameters(C_Dunning.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Dunning_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Dunning with UUID " + C_Dunning.getUUID());
			}
		} else {
			this.setC_Dunning_ID(0);
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
		if (get_ID() != 0) {
			return;
		}
		if (C_DunningLevel != null) {
			// Since an entity was passed, make sure it's in the DB
			MDunningLevel foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_DunningLevel", "C_DunningLevel_UU=?", get_TrxName())
							.setParameters(C_DunningLevel.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_DunningLevel_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_DunningLevel with UUID " + C_DunningLevel.getUUID());
			}
		} else {
			this.setC_DunningLevel_ID(0);
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_DunningRun_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getC_DunningRun_UU();
	}
}
