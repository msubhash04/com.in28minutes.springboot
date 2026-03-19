package com.in28minutes.media_application.Entity;

public class PersonV2 {
    private NameEntity nameEntity;

    public PersonV2(NameEntity nameEntity) {
        this.nameEntity = nameEntity;
    }

    public NameEntity getNameEntity() {
        return nameEntity;
    }

    @Override
    public String toString() {
        return "PersonV2{" +
                "nameEntity=" + nameEntity +
                '}';
    }
}
