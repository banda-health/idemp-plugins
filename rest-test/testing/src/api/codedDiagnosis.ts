import { CodedDiagnosis } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi } from './base';

class CodedDiagnosisApi extends BaseApi<CodedDiagnosis> {
	entityName = 'coded-diagnoses';
}

export const codedDiagnosisApi = new CodedDiagnosisApi();
