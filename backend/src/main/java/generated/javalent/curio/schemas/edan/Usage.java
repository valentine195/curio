
package generated.javalent.curio.schemas.edan;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * usage
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "access",
    "text",
    "codes"
})
@Generated("jsonschema2pojo")
public class Usage {

    @JsonProperty("access")
    private String access;
    @JsonProperty("text")
    private String text;
    @JsonProperty("codes")
    private String codes;

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

    @JsonProperty("codes")
    public String getCodes() {
        return codes;
    }

    @JsonProperty("codes")
    public void setCodes(String codes) {
        this.codes = codes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Usage.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("access");
        sb.append('=');
        sb.append(((this.access == null)?"<null>":this.access));
        sb.append(',');
        sb.append("text");
        sb.append('=');
        sb.append(((this.text == null)?"<null>":this.text));
        sb.append(',');
        sb.append("codes");
        sb.append('=');
        sb.append(((this.codes == null)?"<null>":this.codes));
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
        result = ((result* 31)+((this.codes == null)? 0 :this.codes.hashCode()));
        result = ((result* 31)+((this.access == null)? 0 :this.access.hashCode()));
        result = ((result* 31)+((this.text == null)? 0 :this.text.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Usage) == false) {
            return false;
        }
        Usage rhs = ((Usage) other);
        return ((((this.codes == rhs.codes)||((this.codes!= null)&&this.codes.equals(rhs.codes)))&&((this.access == rhs.access)||((this.access!= null)&&this.access.equals(rhs.access))))&&((this.text == rhs.text)||((this.text!= null)&&this.text.equals(rhs.text))));
    }

}
