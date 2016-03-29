package sample;
import com.github.fedy2.weather.data.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by Xing on 29-3-2016.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class NodeReaders
{
    @XmlElement
    public String title;
    @XmlElement
    public String link;
    @XmlElement
    public String language;
    @XmlElement
    public String description;
    @XmlElement
    public Date lastBuildDate;
    @XmlElement
    public long ttl;
    @XmlElement(
            namespace = "http://xml.weather.yahoo.com/ns/rss/1.0"
    )
    public Location location;
    @XmlElement(
            namespace = "http://xml.weather.yahoo.com/ns/rss/1.0"
    )
    public Units units;
    @XmlElement(
            namespace = "http://xml.weather.yahoo.com/ns/rss/1.0"
    )
    public Wind wind;
    @XmlElement(
            namespace = "http://xml.weather.yahoo.com/ns/rss/1.0"
    )
    public Atmosphere atmosphere;
    @XmlElement(
            namespace = "http://xml.weather.yahoo.com/ns/rss/1.0"
    )
    public Astronomy astronomy;
    @XmlElement
    public Image image;
    @XmlElement
    public Item item;

    public NodeReaders() {
    }

    public String getTitle() {
        return this.title;
    }

    public String getLink() {
        return this.link;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getDescription() {
        return this.description;
    }

    public Date getLastBuildDate() {
        return this.lastBuildDate;
    }

    public long getTtl() {
        return this.ttl;
    }

    public Location getLocation() {
        return this.location;
    }

    public Units getUnits() {
        return this.units;
    }

    public Wind getWind() {
        return this.wind;
    }

    public Atmosphere getAtmosphere() {
        return this.atmosphere;
    }

    public Astronomy getAstronomy() {
        return this.astronomy;
    }

    public Image getImage() {
        return this.image;
    }

    public Item getItem() {
        return this.item;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Channel [title=");
        builder.append(this.title);
        builder.append(", link=");
        builder.append(this.link);
        builder.append(", language=");
        builder.append(this.language);
        builder.append(", description=");
        builder.append(this.description);
        builder.append(", lastBuildDate=");
        builder.append(this.lastBuildDate);
        builder.append(", ttl=");
        builder.append(this.ttl);
        builder.append(", location=");
        builder.append(this.location);
        builder.append(", units=");
        builder.append(this.units);
        builder.append(", wind=");
        builder.append(this.wind);
        builder.append(", atmosphere=");
        builder.append(this.atmosphere);
        builder.append(", astronomy=");
        builder.append(this.astronomy);
        builder.append(", image=");
        builder.append(this.image);
        builder.append(", item=");
        builder.append(this.item);
        builder.append("]");
        return builder.toString();
    }
}
