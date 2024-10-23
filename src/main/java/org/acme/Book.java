package org.acme;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class Book {
    public int id;
    public String title ;
    public String author;
    public int yearOfPublication;
}
