package pub.guoxin.mongo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.querydsl.core.annotations.QueryEntity;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by guoxin on 17-8-12.
 */
@Entity
@QueryEntity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User implements Serializable {
    @Id
    private String id;
    private String username;
    private String password;
    private String email;
    private Date lastPasswordResetDate;
    private List<String> roles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public void setLastPasswordResetDate(Date lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
