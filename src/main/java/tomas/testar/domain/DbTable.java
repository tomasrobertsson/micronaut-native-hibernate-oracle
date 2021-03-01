package tomas.testar.domain;

import io.micronaut.data.annotation.DateCreated;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "MessageTable")
@Table
public class DbTable {
    private Long ID;
    private String message;
    private MessageType messageType;


    private LocalDateTime lastUpdated;

    @DateCreated
    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getMessageType() {
        return messageType.name();
    }

    public void setMessageType(String messageType) {
        this.messageType = MessageType.valueOf(messageType);
    }

    public DbTable() {
    }

    public DbTable(String message) {
        setMessage(message);
        this.messageType = MessageType.secret;

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
        return Objects.equals(ID, dbTable.ID) && Objects.equals(message, dbTable.message) && messageType == dbTable.messageType && Objects.equals(lastUpdated, dbTable.lastUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, message, messageType, lastUpdated);
    }

    @Override
    public String toString() {
        return "DbTable{" +
                "ID=" + ID +
                ", message='" + message + '\'' +
                ", messageType=" + messageType +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
