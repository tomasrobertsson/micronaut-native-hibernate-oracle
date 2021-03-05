package tomas.testar.properties;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class User {
    private String name;
    private long value;
    private Colors colors;

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public long getValue() { return value; }
    public void setValue(long value) { this.value = value; }

    public Colors getColors() { return colors; }
    public void setColors(Colors value) { this.colors = value; }
}
