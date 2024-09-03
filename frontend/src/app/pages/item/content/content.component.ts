import { Component, Input, OnInit } from '@angular/core';
import { LabeledContent } from '../../../interfaces/items/smithsonian';
import { LabeledContentComponent } from './labeled-content/labeled-content.component';

type ContentMap = Map<string, string[]>;

@Component({
  selector: 'app-content',
  standalone: true,
  imports: [LabeledContentComponent],
  templateUrl: './content.component.html',
  styleUrl: './content.component.scss',
})
export class ContentComponent implements OnInit {
  ngOnInit(): void {
    console.log(
      '🚀 ~ file: content.component.ts:38 ~ content:',
      this.content,
      this.seeMore
    );
  }
  @Input({
    required: true,
    transform: (value: LabeledContent[]) => {
      let contentMap = new Map<string, string[]>();
      for (const labeledContent of value ?? []) {
        const arr = contentMap.get(labeledContent.label) ?? [];
        arr.push(labeledContent.content);
        contentMap.set(labeledContent.label, arr);
      }
      return contentMap;
    },
  })
  content!: ContentMap;

  @Input() url: string | null = null;

  get seeMore() {
    return this.content.get('See more items in');
  }
}
