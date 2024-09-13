import { Link } from '../general/utility';

export const Schema = {
  EDANMD: 'edanmd',
} as const;
export type Schema = (typeof Schema)[keyof typeof Schema];
export const UnitCode = {
  NASM: 'NASM',
} as const;
export type UnitCode = (typeof UnitCode)[keyof typeof UnitCode];

export interface SmithsonianItem {
  id: string;
  title: string;
  unitCode: UnitCode;
  type: Schema;
  url: string;
  content: SmithsonianContent;
}

interface SmithsonianContent {
  freetext: FreeText;
  indexedStructured: IndexedStructured;
  descriptiveNonRepeating: DescriptiveNonRepeating;
}

export const MediaType = {
  IMAGES: 'Images',
} as const;
export type MediaType = (typeof MediaType)[keyof typeof MediaType];

interface Media {
  id: string;
  guid: Link;
  type: MediaType;
  idsId: string;
  usage: {
    access: string;
  };
  content: Link;
  thumbnail: Link;
  altTextAccessibility: string;
  resources: MediaResource[];
}

type MediaResource = ImageResource;
interface ImageResource {
  label: string;
  url: Link;
  width?: number;
  height?: number;
  dimensions?: string;
}
interface DescriptiveNonRepeating {
  guid: Link;
  title: LabeledContent;
  record_ID: string;
  unit_code: UnitCode;
  title_sort: string;
  data_source: string;
  record_link: Link;
  online_media: {
    media: Media[];
    mediaCount: number;
  };
  metadata_usage: {
    access: string;
  };
}
interface IndexedStructured {
  name: string[];
  place: string[];
  topic: string[];
  exhibition: { building: string }[];
  usage_flag: string[];
  geoLocation: any[];
  object_type: string[];
  onPhysicalExhibit: string[];
  online_media_type: string[];
}
interface FreeText {
  name: LabeledContent[];
  notes: LabeledContent[];
  place: LabeledContent[];
  setName: LabeledContent[];
  creditLine: LabeledContent[];
  dataSource: LabeledContent[];
  identifier: LabeledContent[];
  objectType: LabeledContent[];
  objectRights: LabeledContent[];
  physicalDescription: LabeledContent[];
}

export interface LabeledContent {
  label: string;
  content: string;
}
