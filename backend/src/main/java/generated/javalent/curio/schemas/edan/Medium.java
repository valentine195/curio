
package generated.javalent.curio.schemas.edan;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Online Media Element Object (DRAFT)
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "content",
    "summary",
    "guid",
    "voyagerId",
    "type",
    "thumbnail",
    "idsId",
    "caption",
    "alt",
    "credit",
    "rights",
    "mime_type",
    "usage",
    "usage_flag"
})
@Generated("jsonschema2pojo")
public class Medium {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("content")
    private String content;
    @JsonProperty("summary")
    private String summary;
    @JsonProperty("guid")
    private String guid;
    @JsonProperty("voyagerId")
    private String voyagerId;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("type")
    private String type;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("thumbnail")
    private String thumbnail;
    @JsonProperty("idsId")
    private String idsId;
    @JsonProperty("caption")
    private String caption;
    @JsonProperty("alt")
    private String alt;
    @JsonProperty("credit")
    private String credit;
    @JsonProperty("rights")
    private String rights;
    @JsonProperty("mime_type")
    private String mimeType;
    /**
     * usage
     * <p>
     * 
     * 
     */
    @JsonProperty("usage")
    private Usage usage;
    /**
     * usage_flag
     * <p>
     * 
     * 
     */
    @JsonProperty("usage_flag")
    private String usageFlag;

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

    @JsonProperty("summary")
    public String getSummary() {
        return summary;
    }

    @JsonProperty("summary")
    public void setSummary(String summary) {
        this.summary = summary;
    }

    @JsonProperty("guid")
    public String getGuid() {
        return guid;
    }

    @JsonProperty("guid")
    public void setGuid(String guid) {
        this.guid = guid;
    }

    @JsonProperty("voyagerId")
    public String getVoyagerId() {
        return voyagerId;
    }

    @JsonProperty("voyagerId")
    public void setVoyagerId(String voyagerId) {
        this.voyagerId = voyagerId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("thumbnail")
    public String getThumbnail() {
        return thumbnail;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("thumbnail")
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @JsonProperty("idsId")
    public String getIdsId() {
        return idsId;
    }

    @JsonProperty("idsId")
    public void setIdsId(String idsId) {
        this.idsId = idsId;
    }

    @JsonProperty("caption")
    public String getCaption() {
        return caption;
    }

    @JsonProperty("caption")
    public void setCaption(String caption) {
        this.caption = caption;
    }

    @JsonProperty("alt")
    public String getAlt() {
        return alt;
    }

    @JsonProperty("alt")
    public void setAlt(String alt) {
        this.alt = alt;
    }

    @JsonProperty("credit")
    public String getCredit() {
        return credit;
    }

    @JsonProperty("credit")
    public void setCredit(String credit) {
        this.credit = credit;
    }

    @JsonProperty("rights")
    public String getRights() {
        return rights;
    }

    @JsonProperty("rights")
    public void setRights(String rights) {
        this.rights = rights;
    }

    @JsonProperty("mime_type")
    public String getMimeType() {
        return mimeType;
    }

    @JsonProperty("mime_type")
    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    /**
     * usage
     * <p>
     * 
     * 
     */
    @JsonProperty("usage")
    public Usage getUsage() {
        return usage;
    }

    /**
     * usage
     * <p>
     * 
     * 
     */
    @JsonProperty("usage")
    public void setUsage(Usage usage) {
        this.usage = usage;
    }

    /**
     * usage_flag
     * <p>
     * 
     * 
     */
    @JsonProperty("usage_flag")
    public String getUsageFlag() {
        return usageFlag;
    }

    /**
     * usage_flag
     * <p>
     * 
     * 
     */
    @JsonProperty("usage_flag")
    public void setUsageFlag(String usageFlag) {
        this.usageFlag = usageFlag;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Medium.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("content");
        sb.append('=');
        sb.append(((this.content == null)?"<null>":this.content));
        sb.append(',');
        sb.append("summary");
        sb.append('=');
        sb.append(((this.summary == null)?"<null>":this.summary));
        sb.append(',');
        sb.append("guid");
        sb.append('=');
        sb.append(((this.guid == null)?"<null>":this.guid));
        sb.append(',');
        sb.append("voyagerId");
        sb.append('=');
        sb.append(((this.voyagerId == null)?"<null>":this.voyagerId));
        sb.append(',');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
        sb.append(',');
        sb.append("thumbnail");
        sb.append('=');
        sb.append(((this.thumbnail == null)?"<null>":this.thumbnail));
        sb.append(',');
        sb.append("idsId");
        sb.append('=');
        sb.append(((this.idsId == null)?"<null>":this.idsId));
        sb.append(',');
        sb.append("caption");
        sb.append('=');
        sb.append(((this.caption == null)?"<null>":this.caption));
        sb.append(',');
        sb.append("alt");
        sb.append('=');
        sb.append(((this.alt == null)?"<null>":this.alt));
        sb.append(',');
        sb.append("credit");
        sb.append('=');
        sb.append(((this.credit == null)?"<null>":this.credit));
        sb.append(',');
        sb.append("rights");
        sb.append('=');
        sb.append(((this.rights == null)?"<null>":this.rights));
        sb.append(',');
        sb.append("mimeType");
        sb.append('=');
        sb.append(((this.mimeType == null)?"<null>":this.mimeType));
        sb.append(',');
        sb.append("usage");
        sb.append('=');
        sb.append(((this.usage == null)?"<null>":this.usage));
        sb.append(',');
        sb.append("usageFlag");
        sb.append('=');
        sb.append(((this.usageFlag == null)?"<null>":this.usageFlag));
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
        result = ((result* 31)+((this.summary == null)? 0 :this.summary.hashCode()));
        result = ((result* 31)+((this.thumbnail == null)? 0 :this.thumbnail.hashCode()));
        result = ((result* 31)+((this.idsId == null)? 0 :this.idsId.hashCode()));
        result = ((result* 31)+((this.usage == null)? 0 :this.usage.hashCode()));
        result = ((result* 31)+((this.alt == null)? 0 :this.alt.hashCode()));
        result = ((result* 31)+((this.caption == null)? 0 :this.caption.hashCode()));
        result = ((result* 31)+((this.mimeType == null)? 0 :this.mimeType.hashCode()));
        result = ((result* 31)+((this.type == null)? 0 :this.type.hashCode()));
        result = ((result* 31)+((this.content == null)? 0 :this.content.hashCode()));
        result = ((result* 31)+((this.voyagerId == null)? 0 :this.voyagerId.hashCode()));
        result = ((result* 31)+((this.usageFlag == null)? 0 :this.usageFlag.hashCode()));
        result = ((result* 31)+((this.rights == null)? 0 :this.rights.hashCode()));
        result = ((result* 31)+((this.guid == null)? 0 :this.guid.hashCode()));
        result = ((result* 31)+((this.credit == null)? 0 :this.credit.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Medium) == false) {
            return false;
        }
        Medium rhs = ((Medium) other);
        return (((((((((((((((this.summary == rhs.summary)||((this.summary!= null)&&this.summary.equals(rhs.summary)))&&((this.thumbnail == rhs.thumbnail)||((this.thumbnail!= null)&&this.thumbnail.equals(rhs.thumbnail))))&&((this.idsId == rhs.idsId)||((this.idsId!= null)&&this.idsId.equals(rhs.idsId))))&&((this.usage == rhs.usage)||((this.usage!= null)&&this.usage.equals(rhs.usage))))&&((this.alt == rhs.alt)||((this.alt!= null)&&this.alt.equals(rhs.alt))))&&((this.caption == rhs.caption)||((this.caption!= null)&&this.caption.equals(rhs.caption))))&&((this.mimeType == rhs.mimeType)||((this.mimeType!= null)&&this.mimeType.equals(rhs.mimeType))))&&((this.type == rhs.type)||((this.type!= null)&&this.type.equals(rhs.type))))&&((this.content == rhs.content)||((this.content!= null)&&this.content.equals(rhs.content))))&&((this.voyagerId == rhs.voyagerId)||((this.voyagerId!= null)&&this.voyagerId.equals(rhs.voyagerId))))&&((this.usageFlag == rhs.usageFlag)||((this.usageFlag!= null)&&this.usageFlag.equals(rhs.usageFlag))))&&((this.rights == rhs.rights)||((this.rights!= null)&&this.rights.equals(rhs.rights))))&&((this.guid == rhs.guid)||((this.guid!= null)&&this.guid.equals(rhs.guid))))&&((this.credit == rhs.credit)||((this.credit!= null)&&this.credit.equals(rhs.credit))));
    }

}
