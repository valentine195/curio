import { Component, inject, Input } from '@angular/core';
import { GalleryModule, GalleryItem } from 'ng-gallery';
import { DeviceDetectorService } from 'ngx-device-detector';

@Component({
  selector: 'app-gallery',
  standalone: true,
  imports: [GalleryModule],
  templateUrl: './gallery.component.html',
  styleUrl: './gallery.component.scss',
})
export class GalleryComponent {
  private deviceDetector = inject(DeviceDetectorService);
  isMobile = this.deviceDetector.isMobile();

  @Input({ required: true }) images: GalleryItem[] = [];
}
