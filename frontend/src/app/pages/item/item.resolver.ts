import { inject } from '@angular/core';
import { ResolveFn } from '@angular/router';
import { ItemsService } from '../../services/items.service';
import { ResponseItem } from '../../interfaces/museums/response-item';

export const itemResolver: ResolveFn<ResponseItem> = (route) => {
  return inject(ItemsService).getItem(route.paramMap.get("item")!);
};
