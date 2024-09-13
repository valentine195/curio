
package generated.schemas.edan;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * EdanMDM
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "descriptiveNonRepeating",
    "indexedStructured",
    "descriptiveOptional",
    "freetext"
})
@Generated("jsonschema2pojo")
public class Edanmdm {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("descriptiveNonRepeating")
    private DescriptiveNonRepeating descriptiveNonRepeating;
    @JsonProperty("indexedStructured")
    private IndexedStructured indexedStructured;
    @JsonProperty("descriptiveOptional")
    private DescriptiveOptional descriptiveOptional;
    @JsonProperty("freetext")
    private Freetext freetext;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("descriptiveNonRepeating")
    public DescriptiveNonRepeating getDescriptiveNonRepeating() {
        return descriptiveNonRepeating;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("descriptiveNonRepeating")
    public void setDescriptiveNonRepeating(DescriptiveNonRepeating descriptiveNonRepeating) {
        this.descriptiveNonRepeating = descriptiveNonRepeating;
    }

    @JsonProperty("indexedStructured")
    public IndexedStructured getIndexedStructured() {
        return indexedStructured;
    }

    @JsonProperty("indexedStructured")
    public void setIndexedStructured(IndexedStructured indexedStructured) {
        this.indexedStructured = indexedStructured;
    }

    @JsonProperty("descriptiveOptional")
    public DescriptiveOptional getDescriptiveOptional() {
        return descriptiveOptional;
    }

    @JsonProperty("descriptiveOptional")
    public void setDescriptiveOptional(DescriptiveOptional descriptiveOptional) {
        this.descriptiveOptional = descriptiveOptional;
    }

    @JsonProperty("freetext")
    public Freetext getFreetext() {
        return freetext;
    }

    @JsonProperty("freetext")
    public void setFreetext(Freetext freetext) {
        this.freetext = freetext;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Edanmdm.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("descriptiveNonRepeating");
        sb.append('=');
        sb.append(((this.descriptiveNonRepeating == null)?"<null>":this.descriptiveNonRepeating));
        sb.append(',');
        sb.append("indexedStructured");
        sb.append('=');
        sb.append(((this.indexedStructured == null)?"<null>":this.indexedStructured));
        sb.append(',');
        sb.append("descriptiveOptional");
        sb.append('=');
        sb.append(((this.descriptiveOptional == null)?"<null>":this.descriptiveOptional));
        sb.append(',');
        sb.append("freetext");
        sb.append('=');
        sb.append(((this.freetext == null)?"<null>":this.freetext));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.descriptiveNonRepeating == null)? 0 :this.descriptiveNonRepeating.hashCode()));
        result = ((result* 31)+((this.indexedStructured == null)? 0 :this.indexedStructured.hashCode()));
        result = ((result* 31)+((this.descriptiveOptional == null)? 0 :this.descriptiveOptional.hashCode()));
        result = ((result* 31)+((this.freetext == null)? 0 :this.freetext.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Edanmdm) == false) {
            return false;
        }
        Edanmdm rhs = ((Edanmdm) other);
        return (((((this.descriptiveNonRepeating == rhs.descriptiveNonRepeating)||((this.descriptiveNonRepeating!= null)&&this.descriptiveNonRepeating.equals(rhs.descriptiveNonRepeating)))&&((this.indexedStructured == rhs.indexedStructured)||((this.indexedStructured!= null)&&this.indexedStructured.equals(rhs.indexedStructured))))&&((this.descriptiveOptional == rhs.descriptiveOptional)||((this.descriptiveOptional!= null)&&this.descriptiveOptional.equals(rhs.descriptiveOptional))))&&((this.freetext == rhs.freetext)||((this.freetext!= null)&&this.freetext.equals(rhs.freetext))));
    }

}
