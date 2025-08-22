import { Component, computed, input } from '@angular/core';
import { ChndmItem } from '../../../../../interfaces/museums/smithsonian/chndm';
import { MatTabsModule } from '@angular/material/tabs';

@Component({
  selector: 'app-chndm',
  imports: [MatTabsModule],
  templateUrl: './chndm.component.html',
  styleUrl: './chndm.component.scss',
})
export class ChndmComponent {
  item = input.required<ChndmItem>();
  content = computed(() => this.item().getContent());
}
