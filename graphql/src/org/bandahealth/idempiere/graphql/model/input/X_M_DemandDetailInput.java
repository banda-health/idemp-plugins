package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MForecastLine;
import org.compiere.model.MOrg;
import org.compiere.model.MRequisitionLine;
import org.compiere.model.Query;
import org.compiere.model.X_M_DemandDetail;
import org.compiere.model.X_M_DemandLine;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_DemandDetail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_DemandDetailInput extends X_M_DemandDetail implements I_M_DemandDetailInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_OrderLine;
	private ForeignEntityInput mM_DemandLine;
	private ForeignEntityInput mM_ForecastLine;
	private ForeignEntityInput mM_RequisitionLine;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_DemandDetail_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_DemandDetailInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
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
	 * @return Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Sales Order Line.
	 *
	 * @param C_OrderLine Sales Order Line
	 */
	@JsonProperty("C_OrderLine")
	public void setC_OrderLineInput(ForeignEntityInput C_OrderLine) {
		this.mC_OrderLine = C_OrderLine;
		if (C_OrderLine != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrderLine_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_OrderLine", "C_OrderLine_UU=?", get_TrxName())
							.setParameters(C_OrderLine.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_OrderLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_OrderLine with UUID " + C_OrderLine.getUUID());
			}
		} else {
			this.setC_OrderLine_ID(0);
		}
	}

	/**
	 * Get Sales Order Line.
	 *
	 * @return Sales Order Line
	 */
	@JsonProperty("C_OrderLine")
	public ForeignEntityInput C_OrderLine() {
		return mC_OrderLine;
	}
	/**
	 * Set Demand Detail.
	 *
	 * @param M_DemandDetail_ID Material Demand Line Source Detail
	 */

	public void setM_DemandDetail_ID(int M_DemandDetail_ID) {
		if (get_ID() == 0) {
			super.setM_DemandDetail_ID(M_DemandDetail_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setM_DemandDetail_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getM_DemandDetail_UU();
	}

	/**
	 * Set Demand Line.
	 *
	 * @param M_DemandLine Material Demand Line
	 */
	@JsonProperty("M_DemandLine")
	public void setM_DemandLineInput(ForeignEntityInput M_DemandLine) {
		this.mM_DemandLine = M_DemandLine;
		if (get_ID() != 0) {
			return;
		}
		if (M_DemandLine != null) {
			// Since an entity was passed, make sure it's in the DB
			X_M_DemandLine foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_DemandLine", "M_DemandLine_UU=?", get_TrxName())
							.setParameters(M_DemandLine.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_DemandLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_DemandLine with UUID " + M_DemandLine.getUUID());
			}
		} else {
			this.setM_DemandLine_ID(0);
		}
	}

	/**
	 * Get Demand Line.
	 *
	 * @return Material Demand Line
	 */
	@JsonProperty("M_DemandLine")
	public ForeignEntityInput M_DemandLine() {
		return mM_DemandLine;
	}

	/**
	 * Set Forecast Line.
	 *
	 * @param M_ForecastLine Forecast Line
	 */
	@JsonProperty("M_ForecastLine")
	public void setM_ForecastLineInput(ForeignEntityInput M_ForecastLine) {
		this.mM_ForecastLine = M_ForecastLine;
		if (M_ForecastLine != null) {
			// Since an entity was passed, make sure it's in the DB
			MForecastLine foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_ForecastLine", "M_ForecastLine_UU=?", get_TrxName())
							.setParameters(M_ForecastLine.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_ForecastLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_ForecastLine with UUID " + M_ForecastLine.getUUID());
			}
		} else {
			this.setM_ForecastLine_ID(0);
		}
	}

	/**
	 * Get Forecast Line.
	 *
	 * @return Forecast Line
	 */
	@JsonProperty("M_ForecastLine")
	public ForeignEntityInput M_ForecastLine() {
		return mM_ForecastLine;
	}

	/**
	 * Set Requisition Line.
	 *
	 * @param M_RequisitionLine Material Requisition Line
	 */
	@JsonProperty("M_RequisitionLine")
	public void setM_RequisitionLineInput(ForeignEntityInput M_RequisitionLine) {
		this.mM_RequisitionLine = M_RequisitionLine;
		if (M_RequisitionLine != null) {
			// Since an entity was passed, make sure it's in the DB
			MRequisitionLine foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_RequisitionLine", "M_RequisitionLine_UU=?", get_TrxName())
							.setParameters(M_RequisitionLine.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_RequisitionLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_RequisitionLine with UUID " + M_RequisitionLine.getUUID());
			}
		} else {
			this.setM_RequisitionLine_ID(0);
		}
	}

	/**
	 * Get Requisition Line.
	 *
	 * @return Material Requisition Line
	 */
	@JsonProperty("M_RequisitionLine")
	public ForeignEntityInput M_RequisitionLine() {
		return mM_RequisitionLine;
	}
}
