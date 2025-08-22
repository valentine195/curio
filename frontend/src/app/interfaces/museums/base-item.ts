// Shared base types for museum items

import { MuseumContent } from '../content/content';
import { UnitCode } from '../items/smithsonian';

export const Museum = {
  NASM: 'National Air and Space Museum',
  CHNDM: 'Cooper Hewitt, Smithsonian Design Museum',
  FSG: 'Freer Gallery of Art and Arthur M. Sackler Gallery',
  NMAI: 'National Museum of the American Indian',
} as const;
export type Museum = (typeof Museum)[keyof typeof Museum];

export interface ItemImage {
  src: string;
  thumb: string;
}

export interface BaseResponseItem<T> {
  content: T;
  id: string;
  institution: string;
  images: ItemImage[];
  museum: Museum;
  unitCode: UnitCode;
  title: string;
  type: string;
  url: string;
  description: string;
}

export abstract class BaseItem {
  abstract getTitle(): string;
  constructor(public base: BaseResponseItem<any>) {}
  getContent(): MuseumContent {
    return this.base.content;
  }
  getId(): string {
    return this.base.id;
  }
  getInstitution(): string {
    return this.base.institution;
  }
  getImages(): ItemImage[] {
    return this.base.images;
  }
  getMuseum(): Museum {
    return this.base.museum;
  }
  getTitleValue(): string {
    return this.base.title;
  }
  getType(): string {
    return this.base.type;
  }
  getUrl(): string {
    return this.base.url;
  }
  getDescription(): string {
    return this.base.description;
  }
}
