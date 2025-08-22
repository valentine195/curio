import { EdanMDM } from '../../../../schemas/edan/edanmdm';
import { UnitCode } from '../../items/smithsonian';
import { BaseItem, BaseResponseItem, ItemImage } from '../base-item';

export interface SmithsonianResponseItem extends BaseResponseItem<EdanMDM> {
  unitCode: UnitCode;
}

export class SmithsonianItem extends BaseItem {
  getUnitCode(): UnitCode {
    return this.base.unitCode;
  }
  override getContent(): EdanMDM {
    return this.base.content;
  }
  override getImages(): ItemImage[] {
    return this.base.images;
  }
  override getTitle(): string {
    return this.base.title;
  }

  public getFreetext() {
    return this.getContent().freetext ?? {};
  }
  public getFreetextProperty(property: string) {
    return this.getFreetext()?.[property] ?? [];
  }
  public getPhysicalDescription() {
    return this.buildFreetextMap('physicalDescription');
  }
  public getCreditLine() {
    return this.buildFreetextMap('creditLine');
  }
  public getObjectRights() {
    return this.buildFreetextMap('objectRights');
  }

  private buildFreetextMap(
    property: string,
  ): Map<string, (string | undefined)[]> {
    const map = new Map<string, (string | undefined)[]>();
    for (const { label, content } of this.getFreetextProperty(property)) {
      if (!map.has(label ?? '')) {
        map.set(label ?? '', []);
      }
      map.get(label ?? '')!.push(content);
    }
    return map;
  }
}
