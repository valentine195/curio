import { ImageItem } from 'ng-gallery';
import { SmithsonianItem } from './smithsonian/smithsonian';
import { NasmItem } from './smithsonian/nasm';

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
  title: string;
  type: string;
  url: string;
  description: string;
}

export type ResponseItem = NasmItem;
