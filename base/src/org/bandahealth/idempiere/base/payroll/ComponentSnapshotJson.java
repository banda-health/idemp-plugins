package org.bandahealth.idempiere.base.payroll;

import java.math.BigDecimal;
import java.util.List;

/**
 * Deterministic JSON snapshot of a resolved component catalogue, persisted to
 * BH_Payroll_Run.BH_Components_Snapshot so a locked run's payslips are immune to later
 * component edits. Hand-rolled — no JSON library ships in the base bundle. Field order is
 * fixed so an unchanged catalogue always serializes to the same bytes.
 */
public class ComponentSnapshotJson {

	private ComponentSnapshotJson() {
	}

	public static String toJson(List<PayrollComponent> specs) {
		StringBuilder json = new StringBuilder("[");
		for (int i = 0; i < specs.size(); i++) {
			if (i > 0) {
				json.append(',');
			}
			appendComponent(json, specs.get(i));
		}
		return json.append(']').toString();
	}

	private static void appendComponent(StringBuilder json, PayrollComponent component) {
		json.append('{');
		json.append("\"value\":\"").append(escape(component.code)).append('"');
		json.append(",\"name\":\"").append(escape(component.name)).append('"');
		json.append(",\"category\":\"").append(escape(component.category)).append('"');
		json.append(",\"method\":\"").append(escape(component.method)).append('"');
		json.append(",\"rate\":").append(number(component.rate));
		json.append(",\"floor\":").append(number(component.floor));
		json.append(",\"cap\":").append(number(component.cap));
		json.append(",\"tier1Limit\":").append(number(component.tier1Limit));
		json.append(",\"tier2Limit\":").append(number(component.tier2Limit));
		json.append(",\"employerRate\":").append(number(component.employerRate));
		json.append(",\"taxDeductible\":").append(component.taxDeductible);
		json.append(",\"taxDeductibleCap\":").append(number(component.taxDeductibleCap));
		json.append(",\"seqNo\":").append(component.seqNo);
		json.append(",\"bands\":[");
		for (int i = 0; i < component.bands.size(); i++) {
			if (i > 0) {
				json.append(',');
			}
			PayeBand band = component.bands.get(i);
			json.append("{\"upperLimit\":").append(number(band.upperLimit))
					.append(",\"rate\":").append(number(band.ratePercent)).append('}');
		}
		json.append(']');
		json.append('}');
	}

	private static String number(BigDecimal value) {
		return value == null ? "null" : value.toPlainString();
	}

	private static String escape(String value) {
		if (value == null) {
			return "";
		}
		return value.replace("\\", "\\\\").replace("\"", "\\\"");
	}
}
