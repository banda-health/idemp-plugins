import { Warehouse } from '../types/org.bandahealth.idempiere.rest';
import { BaseApi } from './base';

class WarehouseApi extends BaseApi<Warehouse> {
	entityName = 'warehouses';
}

export const warehouseApi = new WarehouseApi();
