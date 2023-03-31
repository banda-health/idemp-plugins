import { Inventory } from '../types/org.bandahealth.idempiere.rest';
import { DocumentApi } from './documents';

class InventoryApi extends DocumentApi<Inventory> {
	entityName = 'inventory';
}

export const inventoryApi = new InventoryApi();
