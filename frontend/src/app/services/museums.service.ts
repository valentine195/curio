import { HttpClient } from '@angular/common/http';
import { computed, Injectable, signal } from '@angular/core';
import { ConfigService } from '../config/config.service';
import { ItemsResponseData } from '../interfaces/items/items';
import { FilterService } from './filter.service.interface';

type Museum = string;

@Injectable({
  providedIn: 'root',
})
export class MuseumsService implements FilterService<Museum> {
  get baseUrl() {
    return this.config$.config.baseUrl;
  }

  getItems() {
    return this.http$.get<Museum[]>(`${this.baseUrl}/api/museums`);
  }
  filterBy = signal<Museum[]>([]);

  query = computed(() => {
    const arr = [];
    for (const museum of this.filterBy()) {
      arr.push(museum);
    }
    return new URLSearchParams({ museums: arr.join(',') }).toString();
  });
  clear() {
    this.filterBy.set([]);
  }
  toggle(museum: Museum) {
    this.filterBy.update((set) => {
      if (set.includes(museum)) {
        set = set.filter((m) => m != museum);
      } else {
        set = [...set, museum];
      }
      return set;
    });
  }
  constructor(private http$: HttpClient, private config$: ConfigService) {}
}
