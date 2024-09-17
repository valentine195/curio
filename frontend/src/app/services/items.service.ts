import { HttpClient } from '@angular/common/http';
import { computed, Injectable, Signal, signal } from '@angular/core';
import { toObservable, toSignal } from '@angular/core/rxjs-interop';
import { ConfigService } from '../config/config.service';
import { Item, ItemsResponseData } from '../interfaces/items/items';
import { MuseumsService } from './museums.service';
import { exhaustMap, switchMap, tap } from 'rxjs';
import { SmithsonianItem } from '../interfaces/items/smithsonian';
import { ResponseItem } from '../interfaces/museums/response-item';
import { PageEvent } from '@angular/material/paginator';
import { TagsService } from './tags.service';

@Injectable({
  providedIn: 'root',
})
export class ItemsService {
  get baseUrl() {
    return this.config$.config.baseUrl;
  }
  search = signal<string | null>(null);
  page = signal(0);
  pageSize = signal(100);

  handlePageEvent(pageEvent: PageEvent) {
    if (pageEvent.pageIndex != this.page()) {
      this.page.set(pageEvent.pageIndex);
    }
    if (pageEvent.pageSize != this.pageSize()) {
      this.pageSize.set(pageEvent.pageSize);
    }
  }

  setPage(page: number) {
    this.page.set(page);
  }
  queryParams = computed(() => {
    const params = new URLSearchParams({
      page: `${this.page()}`,
      size: `${this.pageSize()}`,
    });
    const museums = this.museums$.filterBy();
    if (museums.length) {
      params.append(
        'museums',
        [...museums].map((s) => s.replaceAll(',', '|')).join(',')
      );
    }
    const tags = this.tags$.filterBy();
    if (tags.length) {
      params.append(
        'tags',
        [...tags].map((s) => s.replaceAll(',', '|')).join(',')
      );
    }
    const query = this.search();
    if (query) {
      params.append('query', query);
    }
    return params;
  });

  items = signal<Item[] | null>(null);
  items$ = toObservable(this.queryParams).pipe(
    // Watch for user changes
    // Only make http request for users larger than 0
    tap((params) => console.log('params', params.toString())), // Just some debugging
    switchMap(
      (
        params // Don't execute the http request if one is already in progress
      ) => {
        console.log('requesting');
        return this.http$
          .get<ItemsResponseData>(
            `${this.baseUrl}/api/items?${params.toString()}`
          ) // Make the http request
          .pipe(tap((response) => this.items.set(response.content))); // Update the response
      }
    )
  );

  getItem(id: string) {
    return this.http$.get<ResponseItem>(`${this.baseUrl}/api/items/${id}`);
  }

  constructor(
    private http$: HttpClient,
    private config$: ConfigService,
    private museums$: MuseumsService,
    private tags$: TagsService
  ) {}
}
