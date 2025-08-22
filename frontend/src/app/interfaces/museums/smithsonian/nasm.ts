import { UnitCode } from '../../items/smithsonian';
import { Museum } from '../base-item';
import { SmithsonianItem, SmithsonianResponseItem } from './smithsonian';

export interface NasmResponseItem extends SmithsonianResponseItem {
  unitCode: typeof UnitCode.NASM;
  museum: typeof Museum.NASM;
}

export class NasmItem extends SmithsonianItem {
  constructor(public override base: NasmResponseItem) {
    super(base);
  }
}
