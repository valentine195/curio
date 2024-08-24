interface Museum {
  name: string;
  institution: string;
}

export interface Item {
  id: string;
  museum: Museum;
  title: string;
  thumbnail: string;
  summary: string;
  physicalDescription: string | null;
  longDescription: string | null;
  tags: string[];
}

interface Sort {
  sorted: boolean;
  unsorted: boolean;
  empty: boolean;
}

interface Pageable {
  pageNumber: number;
  pageSize: number;
  sort: Sort;
  offset: number;
  paged: boolean;
  unpaged: boolean;
}

export interface ItemsResponseData {
  totalPages: number;
  totalElements: number;
  pageable: Pageable;
  number: number;
  sort: Sort;
  first: boolean;
  last: boolean;
  numberOfElements: number;
  size: number;
  empty: boolean;
  content: Item[];
}
