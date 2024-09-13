import { UnitCode } from '../../items/smithsonian';
import { Museum } from '../response-item';
import { SmithsonianItem } from './smithsonian';

export interface NasmItem extends SmithsonianItem {
  unitCode: typeof UnitCode.NASM;
  museum: typeof Museum.NASM;
}
