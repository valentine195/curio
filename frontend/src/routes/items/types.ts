export type Sortable = {
    sorted: boolean;
    empty: boolean;
    unsorted: boolean;
};
export type Pageable = {
    pageNumber: number;
    pageSize: number;
    sort: Sortable;
    offset: number;
    paged: boolean;
    unpaged: boolean;
};
export type Paginated<T> = {
    totalPages: number;
    totalElements: number;
    pageable: Pageable;
    sort: Sortable;
    number: number;
    numberOfElements: number;
    size: number;
    first: boolean;
    last: boolean;
    empty: boolean;
    content: T[];
};
export type Museum = {
    name: string;
    institution: string;
};
export type Item = {
    id: string;
    museum: Museum;
    title: string;
    thumbnail: string;
    summary: string | null;
    physicalDescription: string | null;
    longDescription: string | null;
    tags: string[];
};
export type ItemResponse = Paginated<Item>;
