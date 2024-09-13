import { EdanMDM } from '../../../../schemas/edan/edanmdm';
import { UnitCode } from '../../items/smithsonian';
import { BaseResponseItem } from '../response-item';

export interface SmithsonianItem extends BaseResponseItem<EdanMDM> {
  unitCode: UnitCode;
  
}
