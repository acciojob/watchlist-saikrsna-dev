package com.driver;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    String name;
    int durationInMinutes;
    double imbdRating;

}
