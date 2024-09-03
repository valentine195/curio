import { HttpClient } from '@angular/common/http';
import { Injectable, signal } from '@angular/core';
import { ConfigService } from '../config/config.service';
import { ItemsResponseData } from '../interfaces/items/items';

@Injectable({
  providedIn: 'root',
})
export class TagsService {
  get baseUrl() {
    return this.config$.config.baseUrl;
  }

  getItems() {
    return this.http$.get<string[]>(`${this.baseUrl}/api/tags`);
  }
  constructor(private http$: HttpClient, private config$: ConfigService) {}
}
