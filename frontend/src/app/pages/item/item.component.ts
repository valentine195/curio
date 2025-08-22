import { Component, computed, inject, OnInit, signal } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { filter, map, Observable, of, switchMap, tap } from 'rxjs';
import { ItemsService } from '../../services/items.service';
import { AsyncPipe } from '@angular/common';
import {
  createBaseItem,
  ResponseItem,
} from '../../interfaces/museums/response-item';
import { MuseumsComponent } from './museums/museums.component';
import { ImageItem } from 'ng-gallery';
import { GalleryComponent } from './components/gallery/gallery.component';
import { BaseItem } from '../../interfaces/museums/base-item';
import { toSignal } from '@angular/core/rxjs-interop';

@Component({
  selector: 'app-item',
  imports: [GalleryComponent, AsyncPipe, MuseumsComponent],
  templateUrl: './item.component.html',
  styleUrl: './item.component.scss',
  providers: [],
})
export class ItemComponent implements OnInit {
  private activedRouted = inject(ActivatedRoute);
  private router = inject(Router);
  private itemSerivce = inject(ItemsService);

  item = toSignal(
    this.activedRouted.paramMap.pipe(
      map((m) => m.get('item')),
      switchMap((id) => {
        if (!id) {
          this.router.navigateByUrl('/error');
          return of(null);
        }
        return this.itemSerivce.getItem(id);
      }),
      filter((item) => item != null),
      map((item) => createBaseItem(item)),
      tap((i) => console.log('item', i)),
    ),
  );

  images = computed(() => {
    const item = this.item();
    const images = [];
    if (item) {
      for (const img of item.getImages()) {
        images.push(new ImageItem(img));
      }
    }
    return images;
  });

  ngOnInit() {
    /*     this.activedRouted.paramMap
      .pipe(
        tap((map) => {
          const itemId = map.get('item');
          if (!itemId) {
            this.router.navigateByUrl('/error');
            return;
          }

          this.item$ = this.itemSerivce.getItem(itemId).pipe(
            tap((item) => {
              console.log('🚀 ~ file: item.component.ts:50 ~ item:', item);

              this.item.set(createBaseItem(item));
            }),
          );
        }),
      )
      .subscribe(); */
  }
}
