import { Component, computed, input } from '@angular/core';
import { FsgItem } from '../../../../../interfaces/museums/smithsonian/fsg';
import { TimelineComponent } from '../../../components/timeline/timeline.component';

@Component({
  selector: 'app-fsg',
  imports: [TimelineComponent],
  templateUrl: './fsg.component.html',
  styleUrl: './fsg.component.scss',
})
export class FsgComponent {
  item = input.required<FsgItem>();
}
