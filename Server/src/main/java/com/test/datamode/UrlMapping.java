package com.test.datamode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UrlMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String url;
    String key;

    public UrlMapping() {
    }

    public UrlMapping(Long id, String url, String key) {
        this.id = id;
        this.url = url;
        this.key = key;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
