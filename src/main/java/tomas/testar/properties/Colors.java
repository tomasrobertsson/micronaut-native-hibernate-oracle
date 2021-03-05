package tomas.testar.properties;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class Colors {
    private String primary;
    private String secondary;
    private String last;

    public String getPrimary() { return primary; }
    public void setPrimary(String value) { this.primary = value; }

    public String getSecondary() { return secondary; }
    public void setSecondary(String value) { this.secondary = value; }

    public String getLast() { return last; }
    public void setLast(String value) { this.last = value; }
}
