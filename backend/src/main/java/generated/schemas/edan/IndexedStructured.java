
package generated.schemas.edan;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "sortdate",
    "topic",
    "strat_member",
    "strat_group",
    "coordinates",
    "occupation",
    "object_type",
    "name",
    "usage_flag",
    "online_media_type",
    "language",
    "date",
    "tax_kingdom",
    "geo_age-era",
    "strat_formation",
    "tax_phylum",
    "tax_class",
    "tax_family",
    "tax_order",
    "geo_age-system",
    "geo_age-stage",
    "geo_age-series",
    "common_name",
    "tax_sub-family",
    "culture",
    "online_media_rights",
    "geoLocation",
    "onPhysicalExhibit",
    "exhibition",
    "scientific_name",
    "place"
})
@Generated("jsonschema2pojo")
public class IndexedStructured {

    @JsonProperty("sortdate")
    private List<String> sortdate = new ArrayList<String>();
    @JsonProperty("topic")
    private List<String> topic = new ArrayList<String>();
    @JsonProperty("strat_member")
    private List<String> stratMember = new ArrayList<String>();
    @JsonProperty("strat_group")
    private List<String> stratGroup = new ArrayList<String>();
    @JsonProperty("coordinates")
    private List<String> coordinates = new ArrayList<String>();
    @JsonProperty("occupation")
    private List<String> occupation = new ArrayList<String>();
    @JsonProperty("object_type")
    private List<String> objectType = new ArrayList<String>();
    @JsonProperty("name")
    private List<String> name = new ArrayList<String>();
    @JsonProperty("usage_flag")
    private List<String> usageFlag = new ArrayList<String>();
    @JsonProperty("online_media_type")
    private List<String> onlineMediaType = new ArrayList<String>();
    @JsonProperty("language")
    private List<String> language = new ArrayList<String>();
    @JsonProperty("date")
    private List<String> date = new ArrayList<String>();
    @JsonProperty("tax_kingdom")
    private List<String> taxKingdom = new ArrayList<String>();
    @JsonProperty("geo_age-era")
    private List<String> geoAgeEra = new ArrayList<String>();
    @JsonProperty("strat_formation")
    private List<String> stratFormation = new ArrayList<String>();
    @JsonProperty("tax_phylum")
    private List<String> taxPhylum = new ArrayList<String>();
    @JsonProperty("tax_class")
    private List<String> taxClass = new ArrayList<String>();
    @JsonProperty("tax_family")
    private List<String> taxFamily = new ArrayList<String>();
    @JsonProperty("tax_order")
    private List<String> taxOrder = new ArrayList<String>();
    @JsonProperty("geo_age-system")
    private List<String> geoAgeSystem = new ArrayList<String>();
    @JsonProperty("geo_age-stage")
    private List<String> geoAgeStage = new ArrayList<String>();
    @JsonProperty("geo_age-series")
    private List<String> geoAgeSeries = new ArrayList<String>();
    @JsonProperty("common_name")
    private List<String> commonName = new ArrayList<String>();
    @JsonProperty("tax_sub-family")
    private List<String> taxSubFamily = new ArrayList<String>();
    @JsonProperty("culture")
    private List<String> culture = new ArrayList<String>();
    @JsonProperty("online_media_rights")
    private List<String> onlineMediaRights = new ArrayList<String>();
    @JsonProperty("geoLocation")
    private List<Object> geoLocation = new ArrayList<Object>();
    @JsonProperty("onPhysicalExhibit")
    private List<String> onPhysicalExhibit = new ArrayList<String>();
    @JsonProperty("exhibition")
    private Object exhibition;
    @JsonProperty("scientific_name")
    private List<String> scientificName = new ArrayList<String>();
    @JsonProperty("place")
    private List<String> place = new ArrayList<String>();

    @JsonProperty("sortdate")
    public List<String> getSortdate() {
        return sortdate;
    }

    @JsonProperty("sortdate")
    public void setSortdate(List<String> sortdate) {
        this.sortdate = sortdate;
    }

    @JsonProperty("topic")
    public List<String> getTopic() {
        return topic;
    }

    @JsonProperty("topic")
    public void setTopic(List<String> topic) {
        this.topic = topic;
    }

    @JsonProperty("strat_member")
    public List<String> getStratMember() {
        return stratMember;
    }

    @JsonProperty("strat_member")
    public void setStratMember(List<String> stratMember) {
        this.stratMember = stratMember;
    }

    @JsonProperty("strat_group")
    public List<String> getStratGroup() {
        return stratGroup;
    }

    @JsonProperty("strat_group")
    public void setStratGroup(List<String> stratGroup) {
        this.stratGroup = stratGroup;
    }

    @JsonProperty("coordinates")
    public List<String> getCoordinates() {
        return coordinates;
    }

    @JsonProperty("coordinates")
    public void setCoordinates(List<String> coordinates) {
        this.coordinates = coordinates;
    }

    @JsonProperty("occupation")
    public List<String> getOccupation() {
        return occupation;
    }

    @JsonProperty("occupation")
    public void setOccupation(List<String> occupation) {
        this.occupation = occupation;
    }

    @JsonProperty("object_type")
    public List<String> getObjectType() {
        return objectType;
    }

    @JsonProperty("object_type")
    public void setObjectType(List<String> objectType) {
        this.objectType = objectType;
    }

    @JsonProperty("name")
    public List<String> getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(List<String> name) {
        this.name = name;
    }

    @JsonProperty("usage_flag")
    public List<String> getUsageFlag() {
        return usageFlag;
    }

    @JsonProperty("usage_flag")
    public void setUsageFlag(List<String> usageFlag) {
        this.usageFlag = usageFlag;
    }

    @JsonProperty("online_media_type")
    public List<String> getOnlineMediaType() {
        return onlineMediaType;
    }

    @JsonProperty("online_media_type")
    public void setOnlineMediaType(List<String> onlineMediaType) {
        this.onlineMediaType = onlineMediaType;
    }

    @JsonProperty("language")
    public List<String> getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(List<String> language) {
        this.language = language;
    }

    @JsonProperty("date")
    public List<String> getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(List<String> date) {
        this.date = date;
    }

    @JsonProperty("tax_kingdom")
    public List<String> getTaxKingdom() {
        return taxKingdom;
    }

    @JsonProperty("tax_kingdom")
    public void setTaxKingdom(List<String> taxKingdom) {
        this.taxKingdom = taxKingdom;
    }

    @JsonProperty("geo_age-era")
    public List<String> getGeoAgeEra() {
        return geoAgeEra;
    }

    @JsonProperty("geo_age-era")
    public void setGeoAgeEra(List<String> geoAgeEra) {
        this.geoAgeEra = geoAgeEra;
    }

    @JsonProperty("strat_formation")
    public List<String> getStratFormation() {
        return stratFormation;
    }

    @JsonProperty("strat_formation")
    public void setStratFormation(List<String> stratFormation) {
        this.stratFormation = stratFormation;
    }

    @JsonProperty("tax_phylum")
    public List<String> getTaxPhylum() {
        return taxPhylum;
    }

    @JsonProperty("tax_phylum")
    public void setTaxPhylum(List<String> taxPhylum) {
        this.taxPhylum = taxPhylum;
    }

    @JsonProperty("tax_class")
    public List<String> getTaxClass() {
        return taxClass;
    }

    @JsonProperty("tax_class")
    public void setTaxClass(List<String> taxClass) {
        this.taxClass = taxClass;
    }

    @JsonProperty("tax_family")
    public List<String> getTaxFamily() {
        return taxFamily;
    }

    @JsonProperty("tax_family")
    public void setTaxFamily(List<String> taxFamily) {
        this.taxFamily = taxFamily;
    }

    @JsonProperty("tax_order")
    public List<String> getTaxOrder() {
        return taxOrder;
    }

    @JsonProperty("tax_order")
    public void setTaxOrder(List<String> taxOrder) {
        this.taxOrder = taxOrder;
    }

    @JsonProperty("geo_age-system")
    public List<String> getGeoAgeSystem() {
        return geoAgeSystem;
    }

    @JsonProperty("geo_age-system")
    public void setGeoAgeSystem(List<String> geoAgeSystem) {
        this.geoAgeSystem = geoAgeSystem;
    }

    @JsonProperty("geo_age-stage")
    public List<String> getGeoAgeStage() {
        return geoAgeStage;
    }

    @JsonProperty("geo_age-stage")
    public void setGeoAgeStage(List<String> geoAgeStage) {
        this.geoAgeStage = geoAgeStage;
    }

    @JsonProperty("geo_age-series")
    public List<String> getGeoAgeSeries() {
        return geoAgeSeries;
    }

    @JsonProperty("geo_age-series")
    public void setGeoAgeSeries(List<String> geoAgeSeries) {
        this.geoAgeSeries = geoAgeSeries;
    }

    @JsonProperty("common_name")
    public List<String> getCommonName() {
        return commonName;
    }

    @JsonProperty("common_name")
    public void setCommonName(List<String> commonName) {
        this.commonName = commonName;
    }

    @JsonProperty("tax_sub-family")
    public List<String> getTaxSubFamily() {
        return taxSubFamily;
    }

    @JsonProperty("tax_sub-family")
    public void setTaxSubFamily(List<String> taxSubFamily) {
        this.taxSubFamily = taxSubFamily;
    }

    @JsonProperty("culture")
    public List<String> getCulture() {
        return culture;
    }

    @JsonProperty("culture")
    public void setCulture(List<String> culture) {
        this.culture = culture;
    }

    @JsonProperty("online_media_rights")
    public List<String> getOnlineMediaRights() {
        return onlineMediaRights;
    }

    @JsonProperty("online_media_rights")
    public void setOnlineMediaRights(List<String> onlineMediaRights) {
        this.onlineMediaRights = onlineMediaRights;
    }

    @JsonProperty("geoLocation")
    public List<Object> getGeoLocation() {
        return geoLocation;
    }

    @JsonProperty("geoLocation")
    public void setGeoLocation(List<Object> geoLocation) {
        this.geoLocation = geoLocation;
    }

    @JsonProperty("onPhysicalExhibit")
    public List<String> getOnPhysicalExhibit() {
        return onPhysicalExhibit;
    }

    @JsonProperty("onPhysicalExhibit")
    public void setOnPhysicalExhibit(List<String> onPhysicalExhibit) {
        this.onPhysicalExhibit = onPhysicalExhibit;
    }

    @JsonProperty("exhibition")
    public Object getExhibition() {
        return exhibition;
    }

    @JsonProperty("exhibition")
    public void setExhibition(Object exhibition) {
        this.exhibition = exhibition;
    }

    @JsonProperty("scientific_name")
    public List<String> getScientificName() {
        return scientificName;
    }

    @JsonProperty("scientific_name")
    public void setScientificName(List<String> scientificName) {
        this.scientificName = scientificName;
    }

    @JsonProperty("place")
    public List<String> getPlace() {
        return place;
    }

    @JsonProperty("place")
    public void setPlace(List<String> place) {
        this.place = place;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(IndexedStructured.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("sortdate");
        sb.append('=');
        sb.append(((this.sortdate == null)?"<null>":this.sortdate));
        sb.append(',');
        sb.append("topic");
        sb.append('=');
        sb.append(((this.topic == null)?"<null>":this.topic));
        sb.append(',');
        sb.append("stratMember");
        sb.append('=');
        sb.append(((this.stratMember == null)?"<null>":this.stratMember));
        sb.append(',');
        sb.append("stratGroup");
        sb.append('=');
        sb.append(((this.stratGroup == null)?"<null>":this.stratGroup));
        sb.append(',');
        sb.append("coordinates");
        sb.append('=');
        sb.append(((this.coordinates == null)?"<null>":this.coordinates));
        sb.append(',');
        sb.append("occupation");
        sb.append('=');
        sb.append(((this.occupation == null)?"<null>":this.occupation));
        sb.append(',');
        sb.append("objectType");
        sb.append('=');
        sb.append(((this.objectType == null)?"<null>":this.objectType));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("usageFlag");
        sb.append('=');
        sb.append(((this.usageFlag == null)?"<null>":this.usageFlag));
        sb.append(',');
        sb.append("onlineMediaType");
        sb.append('=');
        sb.append(((this.onlineMediaType == null)?"<null>":this.onlineMediaType));
        sb.append(',');
        sb.append("language");
        sb.append('=');
        sb.append(((this.language == null)?"<null>":this.language));
        sb.append(',');
        sb.append("date");
        sb.append('=');
        sb.append(((this.date == null)?"<null>":this.date));
        sb.append(',');
        sb.append("taxKingdom");
        sb.append('=');
        sb.append(((this.taxKingdom == null)?"<null>":this.taxKingdom));
        sb.append(',');
        sb.append("geoAgeEra");
        sb.append('=');
        sb.append(((this.geoAgeEra == null)?"<null>":this.geoAgeEra));
        sb.append(',');
        sb.append("stratFormation");
        sb.append('=');
        sb.append(((this.stratFormation == null)?"<null>":this.stratFormation));
        sb.append(',');
        sb.append("taxPhylum");
        sb.append('=');
        sb.append(((this.taxPhylum == null)?"<null>":this.taxPhylum));
        sb.append(',');
        sb.append("taxClass");
        sb.append('=');
        sb.append(((this.taxClass == null)?"<null>":this.taxClass));
        sb.append(',');
        sb.append("taxFamily");
        sb.append('=');
        sb.append(((this.taxFamily == null)?"<null>":this.taxFamily));
        sb.append(',');
        sb.append("taxOrder");
        sb.append('=');
        sb.append(((this.taxOrder == null)?"<null>":this.taxOrder));
        sb.append(',');
        sb.append("geoAgeSystem");
        sb.append('=');
        sb.append(((this.geoAgeSystem == null)?"<null>":this.geoAgeSystem));
        sb.append(',');
        sb.append("geoAgeStage");
        sb.append('=');
        sb.append(((this.geoAgeStage == null)?"<null>":this.geoAgeStage));
        sb.append(',');
        sb.append("geoAgeSeries");
        sb.append('=');
        sb.append(((this.geoAgeSeries == null)?"<null>":this.geoAgeSeries));
        sb.append(',');
        sb.append("commonName");
        sb.append('=');
        sb.append(((this.commonName == null)?"<null>":this.commonName));
        sb.append(',');
        sb.append("taxSubFamily");
        sb.append('=');
        sb.append(((this.taxSubFamily == null)?"<null>":this.taxSubFamily));
        sb.append(',');
        sb.append("culture");
        sb.append('=');
        sb.append(((this.culture == null)?"<null>":this.culture));
        sb.append(',');
        sb.append("onlineMediaRights");
        sb.append('=');
        sb.append(((this.onlineMediaRights == null)?"<null>":this.onlineMediaRights));
        sb.append(',');
        sb.append("geoLocation");
        sb.append('=');
        sb.append(((this.geoLocation == null)?"<null>":this.geoLocation));
        sb.append(',');
        sb.append("onPhysicalExhibit");
        sb.append('=');
        sb.append(((this.onPhysicalExhibit == null)?"<null>":this.onPhysicalExhibit));
        sb.append(',');
        sb.append("exhibition");
        sb.append('=');
        sb.append(((this.exhibition == null)?"<null>":this.exhibition));
        sb.append(',');
        sb.append("scientificName");
        sb.append('=');
        sb.append(((this.scientificName == null)?"<null>":this.scientificName));
        sb.append(',');
        sb.append("place");
        sb.append('=');
        sb.append(((this.place == null)?"<null>":this.place));
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
        result = ((result* 31)+((this.date == null)? 0 :this.date.hashCode()));
        result = ((result* 31)+((this.taxKingdom == null)? 0 :this.taxKingdom.hashCode()));
        result = ((result* 31)+((this.commonName == null)? 0 :this.commonName.hashCode()));
        result = ((result* 31)+((this.occupation == null)? 0 :this.occupation.hashCode()));
        result = ((result* 31)+((this.geoAgeSeries == null)? 0 :this.geoAgeSeries.hashCode()));
        result = ((result* 31)+((this.scientificName == null)? 0 :this.scientificName.hashCode()));
        result = ((result* 31)+((this.language == null)? 0 :this.language.hashCode()));
        result = ((result* 31)+((this.objectType == null)? 0 :this.objectType.hashCode()));
        result = ((result* 31)+((this.taxFamily == null)? 0 :this.taxFamily.hashCode()));
        result = ((result* 31)+((this.taxSubFamily == null)? 0 :this.taxSubFamily.hashCode()));
        result = ((result* 31)+((this.stratMember == null)? 0 :this.stratMember.hashCode()));
        result = ((result* 31)+((this.sortdate == null)? 0 :this.sortdate.hashCode()));
        result = ((result* 31)+((this.stratFormation == null)? 0 :this.stratFormation.hashCode()));
        result = ((result* 31)+((this.taxPhylum == null)? 0 :this.taxPhylum.hashCode()));
        result = ((result* 31)+((this.place == null)? 0 :this.place.hashCode()));
        result = ((result* 31)+((this.taxClass == null)? 0 :this.taxClass.hashCode()));
        result = ((result* 31)+((this.exhibition == null)? 0 :this.exhibition.hashCode()));
        result = ((result* 31)+((this.geoAgeSystem == null)? 0 :this.geoAgeSystem.hashCode()));
        result = ((result* 31)+((this.coordinates == null)? 0 :this.coordinates.hashCode()));
        result = ((result* 31)+((this.stratGroup == null)? 0 :this.stratGroup.hashCode()));
        result = ((result* 31)+((this.geoAgeStage == null)? 0 :this.geoAgeStage.hashCode()));
        result = ((result* 31)+((this.usageFlag == null)? 0 :this.usageFlag.hashCode()));
        result = ((result* 31)+((this.onlineMediaType == null)? 0 :this.onlineMediaType.hashCode()));
        result = ((result* 31)+((this.onlineMediaRights == null)? 0 :this.onlineMediaRights.hashCode()));
        result = ((result* 31)+((this.geoLocation == null)? 0 :this.geoLocation.hashCode()));
        result = ((result* 31)+((this.culture == null)? 0 :this.culture.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.topic == null)? 0 :this.topic.hashCode()));
        result = ((result* 31)+((this.onPhysicalExhibit == null)? 0 :this.onPhysicalExhibit.hashCode()));
        result = ((result* 31)+((this.taxOrder == null)? 0 :this.taxOrder.hashCode()));
        result = ((result* 31)+((this.geoAgeEra == null)? 0 :this.geoAgeEra.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof IndexedStructured) == false) {
            return false;
        }
        IndexedStructured rhs = ((IndexedStructured) other);
        return ((((((((((((((((((((((((((((((((this.date == rhs.date)||((this.date!= null)&&this.date.equals(rhs.date)))&&((this.taxKingdom == rhs.taxKingdom)||((this.taxKingdom!= null)&&this.taxKingdom.equals(rhs.taxKingdom))))&&((this.commonName == rhs.commonName)||((this.commonName!= null)&&this.commonName.equals(rhs.commonName))))&&((this.occupation == rhs.occupation)||((this.occupation!= null)&&this.occupation.equals(rhs.occupation))))&&((this.geoAgeSeries == rhs.geoAgeSeries)||((this.geoAgeSeries!= null)&&this.geoAgeSeries.equals(rhs.geoAgeSeries))))&&((this.scientificName == rhs.scientificName)||((this.scientificName!= null)&&this.scientificName.equals(rhs.scientificName))))&&((this.language == rhs.language)||((this.language!= null)&&this.language.equals(rhs.language))))&&((this.objectType == rhs.objectType)||((this.objectType!= null)&&this.objectType.equals(rhs.objectType))))&&((this.taxFamily == rhs.taxFamily)||((this.taxFamily!= null)&&this.taxFamily.equals(rhs.taxFamily))))&&((this.taxSubFamily == rhs.taxSubFamily)||((this.taxSubFamily!= null)&&this.taxSubFamily.equals(rhs.taxSubFamily))))&&((this.stratMember == rhs.stratMember)||((this.stratMember!= null)&&this.stratMember.equals(rhs.stratMember))))&&((this.sortdate == rhs.sortdate)||((this.sortdate!= null)&&this.sortdate.equals(rhs.sortdate))))&&((this.stratFormation == rhs.stratFormation)||((this.stratFormation!= null)&&this.stratFormation.equals(rhs.stratFormation))))&&((this.taxPhylum == rhs.taxPhylum)||((this.taxPhylum!= null)&&this.taxPhylum.equals(rhs.taxPhylum))))&&((this.place == rhs.place)||((this.place!= null)&&this.place.equals(rhs.place))))&&((this.taxClass == rhs.taxClass)||((this.taxClass!= null)&&this.taxClass.equals(rhs.taxClass))))&&((this.exhibition == rhs.exhibition)||((this.exhibition!= null)&&this.exhibition.equals(rhs.exhibition))))&&((this.geoAgeSystem == rhs.geoAgeSystem)||((this.geoAgeSystem!= null)&&this.geoAgeSystem.equals(rhs.geoAgeSystem))))&&((this.coordinates == rhs.coordinates)||((this.coordinates!= null)&&this.coordinates.equals(rhs.coordinates))))&&((this.stratGroup == rhs.stratGroup)||((this.stratGroup!= null)&&this.stratGroup.equals(rhs.stratGroup))))&&((this.geoAgeStage == rhs.geoAgeStage)||((this.geoAgeStage!= null)&&this.geoAgeStage.equals(rhs.geoAgeStage))))&&((this.usageFlag == rhs.usageFlag)||((this.usageFlag!= null)&&this.usageFlag.equals(rhs.usageFlag))))&&((this.onlineMediaType == rhs.onlineMediaType)||((this.onlineMediaType!= null)&&this.onlineMediaType.equals(rhs.onlineMediaType))))&&((this.onlineMediaRights == rhs.onlineMediaRights)||((this.onlineMediaRights!= null)&&this.onlineMediaRights.equals(rhs.onlineMediaRights))))&&((this.geoLocation == rhs.geoLocation)||((this.geoLocation!= null)&&this.geoLocation.equals(rhs.geoLocation))))&&((this.culture == rhs.culture)||((this.culture!= null)&&this.culture.equals(rhs.culture))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.topic == rhs.topic)||((this.topic!= null)&&this.topic.equals(rhs.topic))))&&((this.onPhysicalExhibit == rhs.onPhysicalExhibit)||((this.onPhysicalExhibit!= null)&&this.onPhysicalExhibit.equals(rhs.onPhysicalExhibit))))&&((this.taxOrder == rhs.taxOrder)||((this.taxOrder!= null)&&this.taxOrder.equals(rhs.taxOrder))))&&((this.geoAgeEra == rhs.geoAgeEra)||((this.geoAgeEra!= null)&&this.geoAgeEra.equals(rhs.geoAgeEra))));
    }

}
