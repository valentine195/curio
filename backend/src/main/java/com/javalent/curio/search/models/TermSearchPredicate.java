package com.javalent.curio.search.models;

import java.util.List;
import lombok.Builder;

@Builder
public final class TermSearchPredicate implements SearchPredicate {
    @Override
    public SearchPredicate.Type type() {
        return Type.TERM;
    };

    public String field;
    public String nested;

    public List<String> terms;
    
/*     public static class TermSearchPredicateBuilder {
        public TermSearchPredicateBuilder terms(Collection<String> terms) {
            if (this.terms == null)
                this.terms = new ArrayList<String>();
            for (String term : terms) {
                this.terms.add(term);
            }
            return this;
        }
    } */
    
}