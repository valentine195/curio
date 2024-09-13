import { Component, computed, inject, OnInit, signal } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable, tap } from 'rxjs';
import { ItemsService } from '../../services/items.service';
import { AsyncPipe } from '@angular/common';
import { ResponseItem } from '../../interfaces/museums/response-item';
import { MuseumsComponent } from './museums/museums.component';
import { ImageItem } from 'ng-gallery';
import { GalleryComponent } from './components/gallery/gallery.component';

@Component({
  selector: 'app-item',
  standalone: true,
  imports: [GalleryComponent, AsyncPipe, MuseumsComponent],
  templateUrl: './item.component.html',
  styleUrl: './item.component.scss',
  providers: [],
})
export class ItemComponent implements OnInit {
  private activedRouted = inject(ActivatedRoute);
  private router = inject(Router);
  private itemSerivce = inject(ItemsService);

  item$: Observable<ResponseItem> | null = null;

  item = signal<ResponseItem | null>(null);
  images = computed(() => {
    const item = this.item();
    const images = [];
    if (item) {
      for (const img of item.images) {
        images.push(new ImageItem(img));
      }
    }
    return images;
  });

  ngOnInit() {
    this.activedRouted.paramMap
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

              this.item.set(item);
            })
          );
        })
      )
      .subscribe();
  }
}
