package pub.guoxin.security.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.collect.Lists;
import com.querydsl.core.annotations.QueryEntity;
import org.mongodb.morphia.annotations.Entity;
import pub.guoxin.security.enums.Role;

import java.util.Date;
import java.util.List;

/**
 * Created by guoxin on 17-8-26.
 */
@Entity
@QueryEntity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    private String id;
    private String username;
    private String password;
    private String email;
    private Date lastPasswordResetDate;
    //    private List<String> roles;
    private List<Role> roles = Lists.newArrayList();

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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
