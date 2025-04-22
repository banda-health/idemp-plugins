package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_ServiceLevel;
import org.compiere.model.X_C_ServiceLevelLine;
import org.compiere.util.Env;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 * Generated Model for C_ServiceLevelLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_ServiceLevelLineInput extends X_C_ServiceLevelLine implements I_C_ServiceLevelLineInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_ServiceLevel;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The C_ServiceLevelLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_ServiceLevelLineInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
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
							.setParameters(AD_Org.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UU " + AD_Org.getUU());
			}
		} else {
			this.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Service Level.
	 *
	 * @param C_ServiceLevel Product Revenue Recognition Service Level 
	 */
	@JsonProperty("C_ServiceLevel")
	public void setC_ServiceLevelInput(ForeignEntityInput C_ServiceLevel) {
		this.mC_ServiceLevel = C_ServiceLevel;
		if (get_ID() != 0) {
			return;
		}
		if (C_ServiceLevel != null) {
			// Since an entity was passed, make sure it's in the DB
			X_C_ServiceLevel foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ServiceLevel", "C_ServiceLevel_UU=?", get_TrxName())
							.setParameters(C_ServiceLevel.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_ServiceLevel_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ServiceLevel with UU " + C_ServiceLevel.getUU());
			}
		} else {
			this.setC_ServiceLevel_ID(0);
		}
	}

	/**
	 * Get Service Level.
	 *
	 * @return Product Revenue Recognition Service Level 
	 */
	@JsonProperty("C_ServiceLevel")
	public ForeignEntityInput C_ServiceLevel() {
		return mC_ServiceLevel;
	}
	/**
	 * Set Service Level Line.
	 *
	 * @param C_ServiceLevelLine_ID Product Revenue Recognition Service Level Line
	 */
	@JsonProperty("C_ServiceLevelLine_ID")
	public void setC_ServiceLevelLine_IDFromJson(int C_ServiceLevelLine_ID) {
		if (get_ID() == 0) {
			super.setC_ServiceLevelLine_ID(C_ServiceLevelLine_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setC_ServiceLevelLine_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getC_ServiceLevelLine_UU();
	}
	/**
	 * Set Processed.
	 *
	 * @param Processed The document has been processed
	 */
	@JsonProperty("Processed")
	public void setProcessedFromJson(boolean Processed) {
		if (get_ID() == 0) {
			super.setProcessed(Processed);
		}
	}
	/**
	 * Set Service date.
	 *
	 * @param ServiceDate Date service was provided
	 */
	@JsonProperty("ServiceDate")
	public void setServiceDateFromJson(Timestamp ServiceDate) {
		if (get_ID() == 0) {
			super.setServiceDate(ServiceDate);
		}
	}
	/**
	 * Set Quantity Provided.
	 *
	 * @param ServiceLevelProvided Quantity of service or product provided
	 */
	@JsonProperty("ServiceLevelProvided")
	public void setServiceLevelProvidedFromJson(BigDecimal ServiceLevelProvided) {
		if (get_ID() == 0) {
			super.setServiceLevelProvided(ServiceLevelProvided);
		}
	}
}
