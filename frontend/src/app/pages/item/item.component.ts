import { Component, computed, inject, OnInit, signal } from '@angular/core';
import { DeviceDetectorService } from 'ngx-device-detector';
import { ActivatedRoute } from '@angular/router';
import { GalleryModule, GalleryItem, ImageItem } from 'ng-gallery';
import {
  LabeledContent,
  MediaType,
  SmithsonianItem,
} from '../../interfaces/items/smithsonian';
import { ContentComponent } from './content/content.component';

@Component({
  selector: 'app-item',
  standalone: true,
  imports: [GalleryModule, ContentComponent],
  templateUrl: './item.component.html',
  styleUrl: './item.component.scss',
})
export class ItemComponent implements OnInit {
  private activatedRoute = inject(ActivatedRoute);
  private deviceDetector = inject(DeviceDetectorService);

  isMobile = this.deviceDetector.isMobile();

  item = signal<SmithsonianItem | null>(null);

  images = computed(() => {
    let item = this.item();
    let galleryItems: GalleryItem[] = [];

    for (const img of item?.content.descriptiveNonRepeating.online_media
      .media ?? []) {
      if (img.type === MediaType.IMAGES) {
        galleryItems.push(
          new ImageItem({
            src: img.content,
            thumb: `${img.thumbnail}&max_w=250`,
          })
        );
      }
    }

    return galleryItems;
  });
  freetext = computed<LabeledContent[][]>(() =>
    Object.values(this.item()?.content.freetext ?? {})
  );
  summary = computed<LabeledContent[]>(() => {
    return (this.item()?.content.freetext.notes ?? []).filter(
      ({ label }) => label === 'Summary'
    );
  });
  url = computed<string | null>(() => {
    return this.item()?.content.descriptiveNonRepeating.guid ?? null;
  });
  /* 
  physicalDescription = computed(() => {
    console.log('🚀 ~ file: item.component.ts:38 ~ physicalDescription:');

    let item = this.item();
    let contentMap = new Map<string, string[]>();
    for (const labeledContent of item?.content.freetext?.physicalDescription ??
      []) {
      const arr = contentMap.get(labeledContent.label) ?? [];
      arr.push(labeledContent.content);
      contentMap.set(labeledContent.label, arr);
    }
    return contentMap;
  });

  objectRights = computed(() => {
    let item = this.item();

    return item?.content.freetext.objectRights ?? [];
  });
  dataSource = computed(() => {
    let item = this.item();

    return item?.content.freetext.dataSource ?? [];
  }); */
  originalLink = computed(() => {
    return this.item()?.content.descriptiveNonRepeating.guid;
  });

  ngOnInit() {
    this.activatedRoute.data.subscribe(({ item }) => {
      console.log('🚀 ~ file: item.component.ts:17 ~ item:', item);
      this.item.set(item);
      // do something with your resolved data ...
    });
  }
}
