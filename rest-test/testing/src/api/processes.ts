import { Process } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi } from './base';

class ProcessApi extends BaseApi<Process> {
	entityName = 'process';
}

export const processApi = new ProcessApi();
