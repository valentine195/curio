import { inject } from '@angular/core';
import { ResolveFn } from '@angular/router';
import { ItemsService } from '../../services/items.service';
import { SmithsonianItem } from '../../interfaces/items/smithsonian';

export const itemResolver: ResolveFn<SmithsonianItem> = (route, state) => {
  return inject(ItemsService).getItem(route.paramMap.get("item")!);
};
