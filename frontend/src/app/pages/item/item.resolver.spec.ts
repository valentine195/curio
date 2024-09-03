import { TestBed } from '@angular/core/testing';
import { ResolveFn } from '@angular/router';

import { itemResolver } from './item.resolver';

describe('itemResolver', () => {
  const executeResolver: ResolveFn<boolean> = (...resolverParameters) => 
      TestBed.runInInjectionContext(() => itemResolver(...resolverParameters));

  beforeEach(() => {
    TestBed.configureTestingModule({});
  });

  it('should be created', () => {
    expect(executeResolver).toBeTruthy();
  });
});
