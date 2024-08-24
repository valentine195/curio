import { HttpClient } from '@angular/common/http';
import { computed, Injectable, Signal, signal } from '@angular/core';
import { toObservable, toSignal } from '@angular/core/rxjs-interop';
import { ConfigService } from '../config/config.service';
import { ItemsResponseData } from '../interfaces/items/item';
import { MuseumsService } from './museums.service';
import { exhaustMap, switchMap, tap } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ItemsService {
  get baseUrl() {
    return this.config$.config.baseUrl;
  }
  page = signal(0);
  setPage(page: number) {
    this.page.set(page);
  }
  queryParams = computed(() => {
    const params = new URLSearchParams({ page: `${this.page()}` });
    const museums = this.museums$.filterBy();
    if (museums.length) {
      params.append(
        'museums',
        [...museums].map((s) => s.replaceAll(',', '|')).join(',')
      );
    }
    return params;
  });

  items = signal<ItemsResponseData | null>(null);
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
          .pipe(tap((response) => this.items.set(response))); // Update the response
      }
    )
  );

  constructor(
    private http$: HttpClient,
    private config$: ConfigService,
    private museums$: MuseumsService
  ) {}
}
