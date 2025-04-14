package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.bandahealth.idempiere.base.model.MWarehouse_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_PP_Product_PlanningResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MResource;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Workflow;
import org.compiere.util.Env;
import org.eevolution.model.MPPProductBOM;
import org.eevolution.model.MPPProductPlanning;
import org.eevolution.model.X_DD_NetworkDistribution;

import java.sql.ResultSet;

/**
 * Generated Model for PP_Product_Planning - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_PP_Product_PlanningInput extends MPPProductPlanning implements I_PP_Product_PlanningInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Workflow;
	private ForeignEntityInput mDD_NetworkDistribution;
	private ForeignEntityInput mM_Product;
	private ForeignEntityInput mM_Warehouse;
	private ForeignEntityInput mOrder_Policy;
	private ForeignEntityInput mPP_Product_BOM;
	private ForeignEntityInput mPlanner;
	private ForeignEntityInput mS_Resource;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The PP_Product_Planning_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_PP_Product_PlanningInput(@JsonProperty("UU") String UU) {
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
	 * Set Workflow.
	 *
	 * @param AD_Workflow Workflow or combination of tasks
	 */
	@JsonProperty("AD_Workflow")
	public void setAD_WorkflowInput(ForeignEntityInput AD_Workflow) {
		this.mAD_Workflow = AD_Workflow;
		if (AD_Workflow != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_Workflow foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Workflow", "AD_Workflow_UU=?", get_TrxName())
							.setParameters(AD_Workflow.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setAD_Workflow_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Workflow with UU " + AD_Workflow.getUU());
			}
		} else {
			this.setAD_Workflow_ID(0);
		}
	}

	/**
	 * Get Workflow.
	 *
	 * @return Workflow or combination of tasks
	 */
	@JsonProperty("AD_Workflow")
	public ForeignEntityInput AD_Workflow() {
		return mAD_Workflow;
	}

	/**
	 * Set Network Distribution.
	 *
	 * @param DD_NetworkDistribution Network Distribution
	 */
	@JsonProperty("DD_NetworkDistribution")
	public void setDD_NetworkDistributionInput(ForeignEntityInput DD_NetworkDistribution) {
		this.mDD_NetworkDistribution = DD_NetworkDistribution;
		if (DD_NetworkDistribution != null) {
			// Since an entity was passed, make sure it's in the DB
			X_DD_NetworkDistribution foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "DD_NetworkDistribution", "DD_NetworkDistribution_UU=?", get_TrxName())
							.setParameters(DD_NetworkDistribution.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setDD_NetworkDistribution_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table DD_NetworkDistribution with UU " + DD_NetworkDistribution.getUU());
			}
		} else {
			this.setDD_NetworkDistribution_ID(0);
		}
	}

	/**
	 * Get Network Distribution.
	 *
	 * @return Network Distribution
	 */
	@JsonProperty("DD_NetworkDistribution")
	public ForeignEntityInput DD_NetworkDistribution() {
		return mDD_NetworkDistribution;
	}
	/**
	 * Set Required Calculate DRP.
	 *
	 * @param IsRequiredDRP Required Calculate DRP
	 */
	@JsonProperty("IsRequiredDRP")
	public void setIsRequiredDRPFromJson(boolean IsRequiredDRP) {
		if (get_ID() == 0) {
			super.setIsRequiredDRP(IsRequiredDRP);
		}
	}
	/**
	 * Set Required Calculate MRP.
	 *
	 * @param IsRequiredMRP Required Calculate MRP
	 */
	@JsonProperty("IsRequiredMRP")
	public void setIsRequiredMRPFromJson(boolean IsRequiredMRP) {
		if (get_ID() == 0) {
			super.setIsRequiredMRP(IsRequiredMRP);
		}
	}

	/**
	 * Set Product/Service.
	 *
	 * @param M_Product Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public void setM_ProductInput(ForeignEntityInput M_Product) {
		this.mM_Product = M_Product;
		if (get_ID() != 0) {
			return;
		}
		if (M_Product != null) {
			// Since an entity was passed, make sure it's in the DB
			MProduct_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Product", "M_Product_UU=?", get_TrxName())
							.setParameters(M_Product.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_Product_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Product with UU " + M_Product.getUU());
			}
		} else {
			this.setM_Product_ID(0);
		}
	}

	/**
	 * Get Product/Service.
	 *
	 * @return Product, Service, Item
	 */
	@JsonProperty("M_Product")
	public ForeignEntityInput M_Product() {
		return mM_Product;
	}

	/**
	 * Set Warehouse.
	 *
	 * @param M_Warehouse Storage Warehouse and Service Point
	 */
	@JsonProperty("M_Warehouse")
	public void setM_WarehouseInput(ForeignEntityInput M_Warehouse) {
		this.mM_Warehouse = M_Warehouse;
		if (M_Warehouse != null) {
			// Since an entity was passed, make sure it's in the DB
			MWarehouse_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Warehouse", "M_Warehouse_UU=?", get_TrxName())
							.setParameters(M_Warehouse.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setM_Warehouse_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Warehouse with UU " + M_Warehouse.getUU());
			}
		} else {
			this.setM_Warehouse_ID(0);
		}
	}

	/**
	 * Get Warehouse.
	 *
	 * @return Storage Warehouse and Service Point
	 */
	@JsonProperty("M_Warehouse")
	public ForeignEntityInput M_Warehouse() {
		return mM_Warehouse;
	}

	/**
	 * Set Order Policy.
	 *
	 * @param Order_Policy Order Policy
	 */
	@JsonProperty("Order_Policy")
	public void setOrder_PolicyInput(ForeignEntityInput Order_Policy) {
		this.mOrder_Policy = Order_Policy;
		if (Order_Policy != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_PP_Product_PlanningResolver.ORDER_POLICY_UUIDS_BY_VALUE.containsValue(Order_Policy.getUU())) {
				throw new AdempiereException("The reference list UU of " + Order_Policy.getUU() +
						" is not in the list defined for the Order_Policy column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(Order_Policy.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setOrder_Policy(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + Order_Policy.getUU());
			}
		} else {
			this.setOrder_Policy(null);
		}
	}

	/**
	 * Get Order Policy.
	 *
	 * @return Order Policy
	 */
	@JsonProperty("Order_Policy")
	public ForeignEntityInput Order_Policy() {
		return mOrder_Policy;
	}

	/**
	 * Set Planner.
	 *
	 * @param Planner Planner
	 */
	@JsonProperty("Planner")
	public void setPlannerInput(ForeignEntityInput Planner) {
		this.mPlanner = Planner;
		if (Planner != null) {
			// Since an entity was passed, make sure it's in the DB
			MUser_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_User", "AD_User_UU=?", get_TrxName())
							.setParameters(Planner.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setPlanner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_User with UU " + Planner.getUU());
			}
		} else {
			this.setPlanner_ID(0);
		}
	}

	/**
	 * Get Planner.
	 *
	 * @return Planner
	 */
	@JsonProperty("Planner")
	public ForeignEntityInput Planner() {
		return mPlanner;
	}

	/**
	 * Set BOM & Formula.
	 *
	 * @param PP_Product_BOM BOM & Formula
	 */
	@JsonProperty("PP_Product_BOM")
	public void setPP_Product_BOMInput(ForeignEntityInput PP_Product_BOM) {
		this.mPP_Product_BOM = PP_Product_BOM;
		if (PP_Product_BOM != null) {
			// Since an entity was passed, make sure it's in the DB
			MPPProductBOM foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PP_Product_BOM", "PP_Product_BOM_UU=?", get_TrxName())
							.setParameters(PP_Product_BOM.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setPP_Product_BOM_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PP_Product_BOM with UU " + PP_Product_BOM.getUU());
			}
		} else {
			this.setPP_Product_BOM_ID(0);
		}
	}

	/**
	 * Get BOM & Formula.
	 *
	 * @return BOM & Formula
	 */
	@JsonProperty("PP_Product_BOM")
	public ForeignEntityInput PP_Product_BOM() {
		return mPP_Product_BOM;
	}
	/**
	 * Set Product Planning.
	 *
	 * @param PP_Product_Planning_ID Product Planning
	 */
	@JsonProperty("PP_Product_Planning_ID")
	public void setPP_Product_Planning_IDFromJson(int PP_Product_Planning_ID) {
		if (get_ID() == 0) {
			super.setPP_Product_Planning_ID(PP_Product_Planning_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setPP_Product_Planning_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getPP_Product_Planning_UU();
	}

	/**
	 * Set Resource.
	 *
	 * @param S_Resource Resource
	 */
	@JsonProperty("S_Resource")
	public void setS_ResourceInput(ForeignEntityInput S_Resource) {
		this.mS_Resource = S_Resource;
		if (get_ID() != 0) {
			return;
		}
		if (S_Resource != null) {
			// Since an entity was passed, make sure it's in the DB
			MResource foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "S_Resource", "S_Resource_UU=?", get_TrxName())
							.setParameters(S_Resource.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setS_Resource_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table S_Resource with UU " + S_Resource.getUU());
			}
		} else {
			this.setS_Resource_ID(0);
		}
	}

	/**
	 * Get Resource.
	 *
	 * @return Resource
	 */
	@JsonProperty("S_Resource")
	public ForeignEntityInput S_Resource() {
		return mS_Resource;
	}
}
