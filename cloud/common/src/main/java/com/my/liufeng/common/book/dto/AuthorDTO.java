package com.my.liufeng.common.book.dto;

public class AuthorDTO {
    private Long id;


    private String name;

    private Integer dynasty;

    private String description;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDynasty() {
        return dynasty;
    }

    public void setDynasty(Integer dynasty) {
        this.dynasty = dynasty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
