package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MOrderLine_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MForecastLine;
import org.compiere.model.MOrg;
import org.compiere.model.MRequisitionLine;
import org.compiere.model.Query;
import org.compiere.model.X_M_DemandDetail;
import org.compiere.model.X_M_DemandLine;

import java.sql.ResultSet;

/**
 * Generated Model for M_DemandDetail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_DemandDetailInput extends X_M_DemandDetail implements I_M_DemandDetailInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_OrderLine;
	private ForeignEntityInput mM_DemandLine;
	private ForeignEntityInput mM_ForecastLine;
	private ForeignEntityInput mM_RequisitionLine;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_DemandDetailInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_M_DemandDetail(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Sales Order Line.
	 *
	 * @param C_OrderLine Sales Order Line
	 */
	@JsonProperty("C_OrderLine")
	public void setC_OrderLineInput(ForeignEntityInput C_OrderLine) {
		this.mC_OrderLine = C_OrderLine;
		MOrderLine_BH foreignEntity;
		if (C_OrderLine != null &&
				(foreignEntity = new Query(getCtx(), "C_OrderLine", "C_OrderLine_UU=?", get_TrxName())
						.setParameters(C_OrderLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_OrderLine_ID(foreignEntity.get_ID());
		} else {
			super.setC_OrderLine_ID(0);
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_DemandDetail_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
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
		X_M_DemandLine foreignEntity;
		if (get_ID() == 0 && M_DemandLine != null &&
				(foreignEntity = new Query(getCtx(), "M_DemandLine", "M_DemandLine_UU=?", get_TrxName())
						.setParameters(M_DemandLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_DemandLine_ID(foreignEntity.get_ID());
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
		MForecastLine foreignEntity;
		if (M_ForecastLine != null &&
				(foreignEntity = new Query(getCtx(), "M_ForecastLine", "M_ForecastLine_UU=?", get_TrxName())
						.setParameters(M_ForecastLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_ForecastLine_ID(foreignEntity.get_ID());
		} else {
			super.setM_ForecastLine_ID(0);
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
		MRequisitionLine foreignEntity;
		if (M_RequisitionLine != null &&
				(foreignEntity = new Query(getCtx(), "M_RequisitionLine", "M_RequisitionLine_UU=?", get_TrxName())
						.setParameters(M_RequisitionLine.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_RequisitionLine_ID(foreignEntity.get_ID());
		} else {
			super.setM_RequisitionLine_ID(0);
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
