import { UnitCode } from '../../items/smithsonian';
import { Museum } from '../base-item';
import { SmithsonianItem, SmithsonianResponseItem } from './smithsonian';

export interface NmaiResponseItem extends SmithsonianResponseItem {
  unitCode: typeof UnitCode.NMAI;
  museum: typeof Museum.NMAI;
}

export class NmaiItem extends SmithsonianItem {
  constructor(public override base: NmaiResponseItem) {
    super(base);
  }
}
