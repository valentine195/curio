import { HttpClient } from '@angular/common/http';
import { computed, Injectable, Signal, signal } from '@angular/core';
import { toObservable, toSignal } from '@angular/core/rxjs-interop';
import { ConfigService } from '../config/config.service';
import { Item, ItemsResponseData } from '../interfaces/items/items';
import { MuseumsService } from './museums.service';
import { exhaustMap, switchMap, tap } from 'rxjs';
import { SmithsonianItem } from '../interfaces/items/smithsonian';
import { ResponseItem } from '../interfaces/museums/response-item';

@Injectable({
  providedIn: 'root',
})
export class ItemsService {
  get baseUrl() {
    return this.config$.config.baseUrl;
  }
  search = signal<string | null>(null);
  searching = computed(() => (this.search()?.length ?? 0) > 0);
  /*   search$ = toObservable(this.search).pipe(
    tap((search) => console.log('search', search)), // Just some debugging
    switchMap(
      (
        search // Don't execute the http request if one is already in progress
      ) => {
        console.log('requesting search');
        return this.http$
          .get<Item[]>(`${this.baseUrl}/api/items/search?query=${search}`) // Make the http request
          .pipe(tap((response) => this.items.set(response))); // Update the response
      }
    )
  ); */

  page = signal(0);
  pageSize = signal(100);
  setPage(page: number) {
    this.page.set(page);
  }
  queryParams = computed(() => {
    const params = new URLSearchParams({
      page: `${this.page()}` /* , size: `${this.pageSize()}` */,
    });
    const museums = this.museums$.filterBy();
    if (museums.length) {
      params.append(
        'museums',
        [...museums].map((s) => s.replaceAll(',', '|')).join(',')
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
    private museums$: MuseumsService
  ) {}
}
