
package generated.javalent.curio.schemas.edan;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "freetext"
})
@Generated("jsonschema2pojo")
public class DescriptiveOptional {

    @JsonProperty("freetext")
    private List<String> freetext = new ArrayList<String>();

    @JsonProperty("freetext")
    public List<String> getFreetext() {
        return freetext;
    }

    @JsonProperty("freetext")
    public void setFreetext(List<String> freetext) {
        this.freetext = freetext;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DescriptiveOptional.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        result = ((result* 31)+((this.freetext == null)? 0 :this.freetext.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DescriptiveOptional) == false) {
            return false;
        }
        DescriptiveOptional rhs = ((DescriptiveOptional) other);
        return ((this.freetext == rhs.freetext)||((this.freetext!= null)&&this.freetext.equals(rhs.freetext)));
    }

}
