package com.javalent.curio.search;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchPredicate {
    public List<String> fields;

    @Builder.Default
    public int fuzzy = 0;

    @Builder.Default
    public int boost = 1;

    public static class SearchPredicateBuilder {
        public SearchPredicateBuilder field(String field) {
            if (this.fields == null)
                this.fields = new ArrayList<String>();
            this.fields.add(field);
            return this;
        }
    }

}
