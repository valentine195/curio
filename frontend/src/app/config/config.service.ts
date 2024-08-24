import { effect, Injectable, signal } from '@angular/core';
import { Configuration } from './configuration';
import { HttpClient } from '@angular/common/http';
import { Observable, tap } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ConfigService {
  config!: Configuration;
  config$: Observable<Configuration>;
  constructor(private http$: HttpClient) {
    this.config$ = this.http$
      .get<Configuration>('/config/app-config.json')
      .pipe(
        tap((config) => {
          this.config = config;
        })
      );
  }
}
