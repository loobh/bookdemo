package com.example.bookdemo.vo;


//public class JsonObject {
//    private Long id;
//    private String node_id;
//    private String name;
//    private String full_name;
//    private Boolean is_private;
//
//
//}

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JsonObject {
    // Getters and Setters for each attribute

    @Id
    private Long id;
    private String node_id;
    private String name;
    private String full_name;
    private Boolean is_private;

    public String getNodeId() {
        return node_id;
    }

    public void setNodeId(String node_id) {
        this.node_id = node_id;
    }

    public String getFullName() {
        return full_name;
    }

    public void setFullName(String full_name) {
        this.full_name = full_name;
    }

    public Boolean getIsPrivate() {
        return is_private;
    }

    public void setIsPrivate(Boolean is_private) {
        this.is_private = is_private;
    }

    @Override
    public String toString() {
        return "JsonObject{" +
                "id=" + id +
                ", node_id='" + node_id + '\'' +
                ", name='" + name + '\'' +
                ", full_name='" + full_name + '\'' +
                ", is_private=" + is_private +
                '}';
    }
}