package tomas.testar.domain;

import javax.persistence.*;

@Entity(name = "MessageTable")
public class DbTable {
    private Long ID;
    private String message;

    public DbTable() {
    }

    public DbTable(String message) {
        setMessage(message);

    }

    @Id
    @GeneratedValue
    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    @Column
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DbTable dbTable = (DbTable) o;

        if (ID != null ? !ID.equals(dbTable.ID) : dbTable.ID != null) return false;
        return message != null ? message.equals(dbTable.message) : dbTable.message == null;
    }

    @Override
    public int hashCode() {
        int result = ID != null ? ID.hashCode() : 0;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DbTable{" +
                "ID=" + ID +
                ", message='" + message + '\'' +
                '}';
    }
}
