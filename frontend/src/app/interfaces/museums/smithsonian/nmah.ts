import { UnitCode } from '../../items/smithsonian';
import { Museum } from '../base-item';
import { SmithsonianItem, SmithsonianResponseItem } from './smithsonian';

export interface NmahResponseItem extends SmithsonianResponseItem {
  unitCode: typeof UnitCode.NMAH;
  museum: typeof Museum.NMAH;
}

export class NmahItem extends SmithsonianItem {
  constructor(public override base: NmahResponseItem) {
    super(base);
  }
}
