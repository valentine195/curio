import { UnitCode } from '../../items/smithsonian';
import { Museum } from '../base-item';
import { SmithsonianItem, SmithsonianResponseItem } from './smithsonian';

export interface ChndmResponseItem extends SmithsonianResponseItem {
  unitCode: typeof UnitCode.CHNDM;
  museum: typeof Museum.CHNDM;
}

export class ChndmItem extends SmithsonianItem {
  constructor(public override base: ChndmResponseItem) {
    super(base);
  }
  override getDescription(): string {
    if (this.base.description) return this.base.description;
    return (
      this.getFreetextProperty('notes').find((l) => l.label === 'Description')
        ?.content ?? ''
    );
  }

  getAccessionNumber(): string | null {
    return (
      this.getFreetextProperty('identifier').find(
        (l) => l.label === 'Accession Number',
      )?.content ?? null
    );
  }

  getCatalogueStatus() {
    return (
      this.getFreetextProperty('notes').find(
        (l) => l.label === 'Catalogue Status',
      )?.content ?? ''
    );
  }

  getDesigner() {
    return (
      this.getFreetextProperty('name').find((l) => l.label === 'Designer')
        ?.content ?? 'Unknown'
    );
  }

  getTimeline(): { label: string; date: string }[] {
    const timeline: { label: string; date: string }[] = [];

    // 1. Object creation / production date

    const dates = this.getFreetextProperty('date');
    if (dates.length && dates[0].content) {
      timeline.push({
        label: 'Created',
        date: dates[0].content,
      });
    }
    for (const date of dates.slice(1)) {
      if (date.label && date.content)
        timeline.push({
          label: date.label,
          date: date.content,
        });
    }
    const accession = this.getAccessionNumber();
    if (accession) {
      timeline.push({
        label: 'Acquired',
        date: accession.split('-').shift()!,
      });
    }

    return timeline;
  }
}
