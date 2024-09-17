import { Signal, WritableSignal } from '@angular/core';
import { Observable } from 'rxjs';

export interface FilterService<T> {
  filterBy: WritableSignal<T[]>;
  query: Signal<string>;
  getItems(): Observable<string[]>;
  clear(): void;
  toggle(arg: T): void;
}
