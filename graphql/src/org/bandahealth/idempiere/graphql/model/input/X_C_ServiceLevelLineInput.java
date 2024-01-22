package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_ServiceLevel;
import org.compiere.model.X_C_ServiceLevelLine;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 * Generated Model for C_ServiceLevelLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_ServiceLevelLineInput extends X_C_ServiceLevelLine implements I_C_ServiceLevelLineInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_ServiceLevel;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_ServiceLevelLineInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_C_ServiceLevelLine(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Service Level.
	 *
	 * @param C_ServiceLevel Product Revenue Recognition Service Level 
	 */
	@JsonProperty("C_ServiceLevel")
	public void setC_ServiceLevelInput(ForeignEntityInput C_ServiceLevel) {
		this.mC_ServiceLevel = C_ServiceLevel;
		X_C_ServiceLevel foreignEntity;
		if (get_ID() == 0 && C_ServiceLevel != null &&
				(foreignEntity = new Query(getCtx(), "C_ServiceLevel", "C_ServiceLevel_UU=?", get_TrxName())
						.setParameters(C_ServiceLevel.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_ServiceLevel_ID(foreignEntity.get_ID());
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

	public void setC_ServiceLevelLine_ID(int C_ServiceLevelLine_ID) {
		if (get_ID() == 0) {
			super.setC_ServiceLevelLine_ID(C_ServiceLevelLine_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_ServiceLevelLine_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_ServiceLevelLine_UU();
	}
	/**
	 * Set Processed.
	 *
	 * @param Processed The document has been processed
	 */

	public void setProcessed(boolean Processed) {
		if (get_ID() == 0) {
			super.setProcessed(Processed);
		}
	}
	/**
	 * Set Service date.
	 *
	 * @param ServiceDate Date service was provided
	 */

	public void setServiceDate(Timestamp ServiceDate) {
		if (get_ID() == 0) {
			super.setServiceDate(ServiceDate);
		}
	}
	/**
	 * Set Quantity Provided.
	 *
	 * @param ServiceLevelProvided Quantity of service or product provided
	 */

	public void setServiceLevelProvided(BigDecimal ServiceLevelProvided) {
		if (get_ID() == 0) {
			super.setServiceLevelProvided(ServiceLevelProvided);
		}
	}
}
