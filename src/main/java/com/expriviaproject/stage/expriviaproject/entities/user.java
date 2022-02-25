package com.expriviaproject.stage.expriviaproject.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//constructor with lombok
@AllArgsConstructor @NoArgsConstructor
public class user {
    //getter&setter with lombok
    @Getter @Setter
    private String id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String surname;
    @Getter @Setter
    private String email;    
}
