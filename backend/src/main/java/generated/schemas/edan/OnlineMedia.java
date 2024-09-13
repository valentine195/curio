
package generated.schemas.edan;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Online Media (DRAFT)
 * <p>
 * Object that stores all media within a record.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "mediaCount",
    "media"
})
@Generated("jsonschema2pojo")
public class OnlineMedia {

    @JsonProperty("mediaCount")
    private String mediaCount;
    @JsonProperty("media")
    private List<Medium> media = new ArrayList<Medium>();

    @JsonProperty("mediaCount")
    public String getMediaCount() {
        return mediaCount;
    }

    @JsonProperty("mediaCount")
    public void setMediaCount(String mediaCount) {
        this.mediaCount = mediaCount;
    }

    @JsonProperty("media")
    public List<Medium> getMedia() {
        return media;
    }

    @JsonProperty("media")
    public void setMedia(List<Medium> media) {
        this.media = media;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(OnlineMedia.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("mediaCount");
        sb.append('=');
        sb.append(((this.mediaCount == null)?"<null>":this.mediaCount));
        sb.append(',');
        sb.append("media");
        sb.append('=');
        sb.append(((this.media == null)?"<null>":this.media));
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
        result = ((result* 31)+((this.mediaCount == null)? 0 :this.mediaCount.hashCode()));
        result = ((result* 31)+((this.media == null)? 0 :this.media.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof OnlineMedia) == false) {
            return false;
        }
        OnlineMedia rhs = ((OnlineMedia) other);
        return (((this.mediaCount == rhs.mediaCount)||((this.mediaCount!= null)&&this.mediaCount.equals(rhs.mediaCount)))&&((this.media == rhs.media)||((this.media!= null)&&this.media.equals(rhs.media))));
    }

}
