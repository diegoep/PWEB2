package br.edu.ifpb.pweb2.cqrsspringcloud.domain;

import com.sun.javafx.beans.IDProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class ACL {

    @Id
    @GeneratedValue
    private Long id;

    private String login;

    private String roleName;

    private String permissionName;

}
