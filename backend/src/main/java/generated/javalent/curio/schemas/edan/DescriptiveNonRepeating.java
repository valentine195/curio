
package generated.javalent.curio.schemas.edan;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "title_sort",
    "title",
    "online_media",
    "data_source",
    "guid",
    "metadata_usage",
    "record_ID",
    "record_link",
    "unit_code"
})
@Generated("jsonschema2pojo")
public class DescriptiveNonRepeating {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("title_sort")
    private String titleSort;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("title")
    private Title title;
    /**
     * Online Media (DRAFT)
     * <p>
     * Object that stores all media within a record.
     * 
     */
    @JsonProperty("online_media")
    @JsonPropertyDescription("Object that stores all media within a record.")
    private OnlineMedia onlineMedia;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("data_source")
    private String dataSource;
    @JsonProperty("guid")
    private String guid;
    @JsonProperty("metadata_usage")
    private MetadataUsage metadataUsage;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("record_ID")
    private String recordID;
    @JsonProperty("record_link")
    private String recordLink;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("unit_code")
    private String unitCode;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("title_sort")
    public String getTitleSort() {
        return titleSort;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("title_sort")
    public void setTitleSort(String titleSort) {
        this.titleSort = titleSort;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("title")
    public Title getTitle() {
        return title;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("title")
    public void setTitle(Title title) {
        this.title = title;
    }

    /**
     * Online Media (DRAFT)
     * <p>
     * Object that stores all media within a record.
     * 
     */
    @JsonProperty("online_media")
    public OnlineMedia getOnlineMedia() {
        return onlineMedia;
    }

    /**
     * Online Media (DRAFT)
     * <p>
     * Object that stores all media within a record.
     * 
     */
    @JsonProperty("online_media")
    public void setOnlineMedia(OnlineMedia onlineMedia) {
        this.onlineMedia = onlineMedia;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("data_source")
    public String getDataSource() {
        return dataSource;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("data_source")
    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    @JsonProperty("guid")
    public String getGuid() {
        return guid;
    }

    @JsonProperty("guid")
    public void setGuid(String guid) {
        this.guid = guid;
    }

    @JsonProperty("metadata_usage")
    public MetadataUsage getMetadataUsage() {
        return metadataUsage;
    }

    @JsonProperty("metadata_usage")
    public void setMetadataUsage(MetadataUsage metadataUsage) {
        this.metadataUsage = metadataUsage;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("record_ID")
    public String getRecordID() {
        return recordID;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("record_ID")
    public void setRecordID(String recordID) {
        this.recordID = recordID;
    }

    @JsonProperty("record_link")
    public String getRecordLink() {
        return recordLink;
    }

    @JsonProperty("record_link")
    public void setRecordLink(String recordLink) {
        this.recordLink = recordLink;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("unit_code")
    public String getUnitCode() {
        return unitCode;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("unit_code")
    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DescriptiveNonRepeating.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("titleSort");
        sb.append('=');
        sb.append(((this.titleSort == null)?"<null>":this.titleSort));
        sb.append(',');
        sb.append("title");
        sb.append('=');
        sb.append(((this.title == null)?"<null>":this.title));
        sb.append(',');
        sb.append("onlineMedia");
        sb.append('=');
        sb.append(((this.onlineMedia == null)?"<null>":this.onlineMedia));
        sb.append(',');
        sb.append("dataSource");
        sb.append('=');
        sb.append(((this.dataSource == null)?"<null>":this.dataSource));
        sb.append(',');
        sb.append("guid");
        sb.append('=');
        sb.append(((this.guid == null)?"<null>":this.guid));
        sb.append(',');
        sb.append("metadataUsage");
        sb.append('=');
        sb.append(((this.metadataUsage == null)?"<null>":this.metadataUsage));
        sb.append(',');
        sb.append("recordID");
        sb.append('=');
        sb.append(((this.recordID == null)?"<null>":this.recordID));
        sb.append(',');
        sb.append("recordLink");
        sb.append('=');
        sb.append(((this.recordLink == null)?"<null>":this.recordLink));
        sb.append(',');
        sb.append("unitCode");
        sb.append('=');
        sb.append(((this.unitCode == null)?"<null>":this.unitCode));
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
        result = ((result* 31)+((this.recordID == null)? 0 :this.recordID.hashCode()));
        result = ((result* 31)+((this.recordLink == null)? 0 :this.recordLink.hashCode()));
        result = ((result* 31)+((this.titleSort == null)? 0 :this.titleSort.hashCode()));
        result = ((result* 31)+((this.onlineMedia == null)? 0 :this.onlineMedia.hashCode()));
        result = ((result* 31)+((this.unitCode == null)? 0 :this.unitCode.hashCode()));
        result = ((result* 31)+((this.guid == null)? 0 :this.guid.hashCode()));
        result = ((result* 31)+((this.title == null)? 0 :this.title.hashCode()));
        result = ((result* 31)+((this.metadataUsage == null)? 0 :this.metadataUsage.hashCode()));
        result = ((result* 31)+((this.dataSource == null)? 0 :this.dataSource.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DescriptiveNonRepeating) == false) {
            return false;
        }
        DescriptiveNonRepeating rhs = ((DescriptiveNonRepeating) other);
        return ((((((((((this.recordID == rhs.recordID)||((this.recordID!= null)&&this.recordID.equals(rhs.recordID)))&&((this.recordLink == rhs.recordLink)||((this.recordLink!= null)&&this.recordLink.equals(rhs.recordLink))))&&((this.titleSort == rhs.titleSort)||((this.titleSort!= null)&&this.titleSort.equals(rhs.titleSort))))&&((this.onlineMedia == rhs.onlineMedia)||((this.onlineMedia!= null)&&this.onlineMedia.equals(rhs.onlineMedia))))&&((this.unitCode == rhs.unitCode)||((this.unitCode!= null)&&this.unitCode.equals(rhs.unitCode))))&&((this.guid == rhs.guid)||((this.guid!= null)&&this.guid.equals(rhs.guid))))&&((this.title == rhs.title)||((this.title!= null)&&this.title.equals(rhs.title))))&&((this.metadataUsage == rhs.metadataUsage)||((this.metadataUsage!= null)&&this.metadataUsage.equals(rhs.metadataUsage))))&&((this.dataSource == rhs.dataSource)||((this.dataSource!= null)&&this.dataSource.equals(rhs.dataSource))));
    }

}
