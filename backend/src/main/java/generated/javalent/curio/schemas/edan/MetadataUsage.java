
package generated.javalent.curio.schemas.edan;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "access",
    "text"
})
@Generated("jsonschema2pojo")
public class MetadataUsage {

    @JsonProperty("access")
    private String access;
    @JsonProperty("text")
    private String text;

    @JsonProperty("access")
    public String getAccess() {
        return access;
    }

    @JsonProperty("access")
    public void setAccess(String access) {
        this.access = access;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(MetadataUsage.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("access");
        sb.append('=');
        sb.append(((this.access == null)?"<null>":this.access));
        sb.append(',');
        sb.append("text");
        sb.append('=');
        sb.append(((this.text == null)?"<null>":this.text));
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
        result = ((result* 31)+((this.access == null)? 0 :this.access.hashCode()));
        result = ((result* 31)+((this.text == null)? 0 :this.text.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof MetadataUsage) == false) {
            return false;
        }
        MetadataUsage rhs = ((MetadataUsage) other);
        return (((this.access == rhs.access)||((this.access!= null)&&this.access.equals(rhs.access)))&&((this.text == rhs.text)||((this.text!= null)&&this.text.equals(rhs.text))));
    }

}
