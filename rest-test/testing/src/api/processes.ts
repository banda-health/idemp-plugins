import { Process } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi } from './base';

class ProcessApi extends BaseApi<Process> {
	entityName = 'processes';
}

export const processApi = new ProcessApi();
