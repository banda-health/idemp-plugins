package org.bandahealth.idempiere.base.utils;

import org.bandahealth.idempiere.base.model.I_BH_Feature_Flag_Rule;
import org.bandahealth.idempiere.base.model.MBHFeatureFlag;
import org.bandahealth.idempiere.base.model.MBHFeatureFlagRule;
import org.bandahealth.idempiere.base.model.MUser_BH;
import org.compiere.model.MRole;
import org.compiere.model.MSystem;
import org.compiere.model.MUser;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.compiere.util.Util;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public final class FeatureFlagUtil {

	private FeatureFlagUtil() {
	}

	private static final Comparator<MBHFeatureFlagRule> RULE_COMPARATOR = Comparator
			.comparingInt(FeatureFlagUtil::getRuleSpecificity).reversed()
			.thenComparing(MBHFeatureFlagRule::getSeqNo, Comparator.reverseOrder())
			.thenComparing(MBHFeatureFlagRule::getBH_Feature_Flag_Rule_ID, Comparator.reverseOrder());

	public static Map<String, Boolean> evaluateAll(Properties ctx, FeatureFlagContext context, String trxName) {
		List<MBHFeatureFlag> flags =
				new Query(ctx, MBHFeatureFlag.Table_Name, null, trxName).setOnlyActiveRecords(true).list();

		Map<String, Boolean> results = new HashMap<>();
		for (MBHFeatureFlag flag : flags) {
			results.put(flag.getName(), isEnabled(ctx, flag, context, trxName));
		}
		return results;
	}

	public static boolean isEnabled(Properties ctx, String flagKey, FeatureFlagContext context, String trxName) {
		MBHFeatureFlag flag = MBHFeatureFlag.getByKey(ctx, flagKey, trxName);
		if (flag == null) {
			return false;
		}
		return isEnabled(ctx, flag, context, trxName);
	}

	public static boolean isEnabled(Properties ctx, MBHFeatureFlag flag, FeatureFlagContext context, String trxName) {
		List<MBHFeatureFlagRule> allRules =
				new Query(ctx, MBHFeatureFlagRule.Table_Name, MBHFeatureFlagRule.COLUMNNAME_BH_Feature_Flag_ID + "=?",
						trxName).setParameters(flag.getBH_Feature_Flag_ID()).setOnlyActiveRecords(true).list();
		List<MBHFeatureFlagRule> matchingRules = allRules.stream()
				.filter(rule -> ruleMatches(rule, context))
				.filter(FeatureFlagUtil::isWithinValidPeriod)
				.sorted(RULE_COMPARATOR)
				.toList();

		if (!matchingRules.isEmpty()) {
			return matchingRules.get(0).isBH_IsEnabled();
		}
		return flag.isBH_DefaultEnabled();
	}

	public static FeatureFlagContext fromContext(Properties ctx) {
		int roleId = Env.getAD_Role_ID(ctx);
		int userId = Env.getAD_User_ID(ctx);
		return new FeatureFlagContext(Env.getAD_Client_ID(ctx), Env.getAD_Org_ID(ctx), roleId, userId,
				resolveEnvironment(ctx), resolveApplicableRoleIds(ctx, roleId, userId), isSystemAdministrator(ctx));
	}

	private static boolean isSystemAdministrator(Properties ctx) {
		MUser user = MUser_BH.get(ctx);
		return user != null && user.isAdministrator();
	}

	/**
	 * Resolves the deployment environment for feature-flag rule matching from {@link MSystem#getSystemStatus()}.
	 * {@link MBHFeatureFlagRule#getBH_Environment()} should use system status values (e.g.
	 * {@link MSystem#SYSTEMSTATUS_Production}).
	 */
	public static String resolveEnvironment(Properties ctx) {
		String systemStatus = MSystem.get(ctx).getSystemStatus();
		return Util.isEmpty(systemStatus) ? null : systemStatus;
	}

	private static Set<Integer> resolveApplicableRoleIds(Properties ctx, int roleId, int userId) {
		if (roleId <= 0) {
			return Set.of();
		}
		MRole role = MRole.get(ctx, roleId, userId, false);
		Set<Integer> roleIds = new HashSet<>();
		roleIds.add(role.getAD_Role_ID());
		for (MRole includedRole : role.getIncludedRoles(true)) {
			roleIds.add(includedRole.getAD_Role_ID());
		}
		return Set.copyOf(roleIds);
	}

	private static boolean ruleMatches(MBHFeatureFlagRule rule, FeatureFlagContext context) {
		if (!matchesNullableInteger(rule.get_Value(I_BH_Feature_Flag_Rule.COLUMNNAME_BH_Rule_Client_ID), context.clientId())) {
			return false;
		}
		if (!matchesNullableInteger(rule.get_Value(I_BH_Feature_Flag_Rule.COLUMNNAME_BH_Rule_Org_ID), context.orgId())) {
			return false;
		}
		if (!matchesRole(rule.get_Value(I_BH_Feature_Flag_Rule.COLUMNNAME_BH_Rule_Role_ID), context)) {
			return false;
		}
		if (!matchesNullableInteger(rule.get_Value(I_BH_Feature_Flag_Rule.COLUMNNAME_BH_Rule_User_ID), context.userId())) {
			return false;
		}
		if (!matchesSystemAdmin(rule, context)) {
			return false;
		}
		return matchesEnvironment(rule.getBH_Environment(), context.environment());
	}

	/**
	 * When {@link MBHFeatureFlagRule#isBH_SystemAdmin()} is false, the rule applies regardless of administrator
	 * status. When true, the rule only applies to system administrators.
	 */
	private static boolean matchesSystemAdmin(MBHFeatureFlagRule rule, FeatureFlagContext context) {
		if (!rule.isBH_SystemAdmin()) {
			return true;
		}
		return context.systemAdministrator();
	}

	private static boolean matchesNullableInteger(Object ruleValue, int contextValue) {
		if (ruleValue == null) {
			return true;
		}
		return ((Number) ruleValue).intValue() == contextValue;
	}

	private static boolean matchesRole(Object ruleValue, FeatureFlagContext context) {
		if (ruleValue == null) {
			return true;
		}
		return context.resolvedRoleIds().contains(((Number) ruleValue).intValue());
	}

	private static boolean matchesEnvironment(String ruleEnvironment, String contextEnvironment) {
		if (ruleEnvironment == null || ruleEnvironment.isBlank()) {
			return true;
		}
		if (contextEnvironment == null || contextEnvironment.isBlank()) {
			return false;
		}
		return ruleEnvironment.equalsIgnoreCase(contextEnvironment);
	}

	private static boolean isWithinValidPeriod(MBHFeatureFlagRule rule) {
		Timestamp now = new Timestamp(System.currentTimeMillis());
		Timestamp validFrom = rule.getValidFrom();
		if (validFrom != null && now.before(validFrom)) {
			return false;
		}
		Timestamp validTo = rule.getValidTo();
		return validTo == null || !now.after(validTo);
	}

	private static int getRuleSpecificity(MBHFeatureFlagRule rule) {
		int specificity = 0;
		if (rule.get_Value(I_BH_Feature_Flag_Rule.COLUMNNAME_BH_Rule_User_ID) != null) {
			specificity += 16;
		}
		if (rule.get_Value(I_BH_Feature_Flag_Rule.COLUMNNAME_BH_Rule_Role_ID) != null) {
			specificity += 8;
		}
		if (rule.get_Value(I_BH_Feature_Flag_Rule.COLUMNNAME_BH_Rule_Org_ID) != null) {
			specificity += 4;
		}
		if (rule.get_Value(I_BH_Feature_Flag_Rule.COLUMNNAME_BH_Rule_Client_ID) != null) {
			specificity += 2;
		}
		if (rule.getBH_Environment() != null && !rule.getBH_Environment().isBlank()) {
			specificity += 1;
		}
		if (rule.isBH_SystemAdmin()) {
			specificity += 32;
		}
		return specificity;
	}
}
