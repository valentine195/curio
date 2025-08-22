import { TimelineData } from '../../../pages/item/components/timeline/timeline.component';
import { UnitCode } from '../../items/smithsonian';
import { Museum } from '../base-item';
import { SmithsonianItem, SmithsonianResponseItem } from './smithsonian';

export interface FsgResponseItem extends SmithsonianResponseItem {
  unitCode: typeof UnitCode.FSG;
  museum: typeof Museum.FSG;
}

export class FsgItem extends SmithsonianItem {
  constructor(public override base: FsgResponseItem) {
    super(base);
  }
  override getDescription(): string {
    if (this.base.description) return this.base.description;
    return (
      this.getFreetextProperty('notes').find((l) => l.label === 'Description')
        ?.content ?? ''
    );
  }

  getProvenance(): TimelineData[] {
    const timeline: TimelineData[] = [];
    // Filter only "Provenance" items and remove empty or notes/references
    const provenances = this.getFreetextProperty('notes')
      .filter((item) => item.label === 'Provenance')
      .map((item) => item.content?.trim())
      .filter(
        (text) =>
          text &&
          !text.toLowerCase().startsWith('notes') &&
          !text.startsWith('['),
      )
      .filter((t) => t != null);

    // Process in consecutive pairs
    for (let i = 0; i < provenances.length; i += 2) {
      const dateText = provenances[i];
      const contentText = provenances[i + 1];
      if (!contentText) continue; // skip incomplete pairs

      let start: string | undefined;
      let end: string | undefined;

      // From XXXX to YYYY
      let match = dateText.match(/from (\d{4}) to (\d{4})/i);
      if (match) {
        start = match[1];
        end = match[2];
      }
      // From XXXX
      else if ((match = dateText.match(/from (\d{4})/i))) {
        start = match[1];
      }
      // To XXXX
      else if ((match = dateText.match(/to (\d{4})/i))) {
        if (!timeline.length) {
          start = match[1];
        } else {
          start = timeline[timeline.length - 1].end?.toString();
          end = match[1];
        }
      }
      // Single year anywhere
      else if ((match = dateText.match(/(\d{4})/))) {
        start = match[1];
      } /* else {
        start = 'unknown';
      } */
      if (!start) continue;
      timeline.push({
        content: contentText,
        start: new Date(start),
        ...(end ? { end: new Date(end) } : {}),
      });
    }
    return timeline;
  }
}
