import { Component, computed, effect, input } from '@angular/core';
import { MatTabsModule } from '@angular/material/tabs';
import { MatExpansionModule } from '@angular/material/expansion';
import { NasmItem } from '../../../../../interfaces/museums/smithsonian/nasm';
import { SafeHtmlPipe } from '../../../../../pipes/safe-html.pipe';

@Component({
  selector: 'app-nasm',
  templateUrl: './nasm.component.html',
  styleUrls: ['./nasm.component.css'],
  imports: [MatTabsModule, MatExpansionModule, SafeHtmlPipe],
})
export class NasmComponent {
  item = input.required<NasmItem>();

  description = computed(() => this.item().description);

  freetext = computed(() => this.item().content.freetext ?? {});

  /** Common freetext properties. */

  physicalDescriptionNotes = computed(() => {
    return this.freetext()
      ?.['notes']?.filter(
        (n) => n.label === 'Physical Description' && n.content?.length,
      )
      .map((n) => n.content);
  });
  /**
   * This seems to be used to describe materials, dimensions, etc.,
   */
  physicalDescription = this.makeComputedMap('physicalDescription');
  creditLine = this.makeComputedMap('creditLine');
  objectRights = this.makeComputedMap('objectRights');
  dataSource = this.makeComputedMap('dataSource');
  identifier = this.makeComputedMap('identifier');

  longDescription = computed(
    () =>
      this.item().content.freetext?.['notes']?.filter(
        (note) => note.label === 'Long Description',
      ) ?? [],
  );

  onExhibit = computed(
    () =>
      this.item().content.indexedStructured?.onPhysicalExhibit?.[0] === 'Yes',
  );
  exhibition = computed(() => {
    if (!this.onExhibit()) return 'This item is not on exhibit.';
    const item = this.item();
    if (!item.content.freetext?.['setName']?.length) return '';
    const setName = item.content.freetext['setName'];
    return `This object can be seen in ${setName[2].content!} at the ${setName[1].content!}.`;
  });

  constructor() {
    effect(() => console.log(this.item()));
  }

  private makeComputedMap(property: string) {
    return computed(() => {
      const map = new Map<string, (string | undefined)[]>();
      for (const { label, content } of this.freetext()[property] ?? []) {
        if (!map.has(label ?? '')) {
          map.set(label ?? '', []);
        }
        map.get(label ?? '')!.push(content);
      }
      return map;
    });
  }
}
