import { BaseItem } from './base-item';
import { NasmItem, NasmResponseItem } from './smithsonian/nasm';
import { ChndmItem, ChndmResponseItem } from './smithsonian/chndm';
import { SmithsonianItem } from './smithsonian/smithsonian';
import { UnitCode } from '../items/smithsonian';
import { FsgItem, FsgResponseItem } from './smithsonian/fsg';
import { NmaiItem, NmaiResponseItem } from './smithsonian/nmai';
import { NmahItem, NmahResponseItem } from './smithsonian/nmah';

/**
 * Response items are items coming from an API call to a museum.
 */
export type ResponseItem =
  | NasmResponseItem
  | ChndmResponseItem
  | FsgResponseItem
  | NmaiResponseItem
  | NmahResponseItem;

// Factory method for creating the correct BaseItem implementation should be moved to a service or utility file to avoid circular dependencies.
// The following code has been removed as it directly references Smithsonian item classes.

export function createBaseItem(item: ResponseItem): BaseItem {
  switch (item.unitCode) {
    case UnitCode.CHNDM: {
      return new ChndmItem(item);
    }
    case UnitCode.NASM: {
      return new NasmItem(item);
    }
    case UnitCode.FSG: {
      return new FsgItem(item);
    }
    case UnitCode.NMAI: {
      return new NmaiItem(item);
    }
    case UnitCode.NMAH: {
      return new NmahItem(item);
    }
    default: {
      return new SmithsonianItem(item);
    }
  }
}
