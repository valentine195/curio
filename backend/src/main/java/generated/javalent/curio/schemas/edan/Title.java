
package generated.javalent.curio.schemas.edan;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "content",
    "label"
})
@Generated("jsonschema2pojo")
public class Title {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("content")
    private String content;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("label")
    private String label;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("content")
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("label")
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Title.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("content");
        sb.append('=');
        sb.append(((this.content == null)?"<null>":this.content));
        sb.append(',');
        sb.append("label");
        sb.append('=');
        sb.append(((this.label == null)?"<null>":this.label));
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
        result = ((result* 31)+((this.content == null)? 0 :this.content.hashCode()));
        result = ((result* 31)+((this.label == null)? 0 :this.label.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Title) == false) {
            return false;
        }
        Title rhs = ((Title) other);
        return (((this.content == rhs.content)||((this.content!= null)&&this.content.equals(rhs.content)))&&((this.label == rhs.label)||((this.label!= null)&&this.label.equals(rhs.label))));
    }

}
