import { HttpClient } from '@angular/common/http';
import {
  computed,
  Injectable,
  Signal,
  signal,
  WritableSignal,
} from '@angular/core';
import { ConfigService } from '../config/config.service';
import { ItemsResponseData } from '../interfaces/items/items';
import { FilterService } from './filter.service.interface';
import { Tag } from '../interfaces/tags/tag';

@Injectable({
  providedIn: 'root',
})
export class TagsService implements FilterService<Tag> {
  constructor(private http$: HttpClient, private config$: ConfigService) {}
  get baseUrl() {
    return this.config$.config.baseUrl;
  }

  getItems() {
    return this.http$.get<string[]>(`${this.baseUrl}/api/tags`);
  }

  filterBy: WritableSignal<Tag[]> = signal([]);
  query: Signal<string> = computed(() => {
    const arr = [];
    for (const museum of this.filterBy()) {
      arr.push(museum);
    }
    return new URLSearchParams({ tags: arr.join(',') }).toString();
  });
  clear(): void {
    this.filterBy.set([]);
  }
  toggle(tag: Tag): void {
    this.filterBy.update((set) => {
      if (set.includes(tag)) {
        set = set.filter((m) => m != tag);
      } else {
        set = [...set, tag];
      }
      return set;
    });
  }
}
