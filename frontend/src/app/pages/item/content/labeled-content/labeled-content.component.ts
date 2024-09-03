import { Component, Input } from '@angular/core';
import { LabeledContent } from '../../../../interfaces/items/smithsonian';

@Component({
  selector: 'app-labeled-content',
  standalone: true,
  imports: [],
  templateUrl: './labeled-content.component.html',
  styleUrl: './labeled-content.component.scss',
})
export class LabeledContentComponent {
  @Input({ required: true }) content!: LabeledContent;
}
