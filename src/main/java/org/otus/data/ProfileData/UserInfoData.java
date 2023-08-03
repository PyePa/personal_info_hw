package org.otus.data.ProfileData;

import com.github.javafaker.Country;

public enum UserInfoData {
    FIRST_NAME("Аяцка"),
    FIRST_NAME_LATIN("Ayatczka"),
    SECOND_NAME("Байжигитович"),
    SECOND_NAME_LATIN("Baizhigitovich"),
    BLOG_NAME("Ayatskiy"),
    BIRTH_DATE("19.01.1996");



    private String name;

    UserInfoData(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}