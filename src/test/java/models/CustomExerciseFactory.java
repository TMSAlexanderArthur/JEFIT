package models;

import com.github.javafaker.Faker;

public class CustomExerciseFactory {

    static Faker faker = new Faker();

    public static CustomExercise get() {
        return CustomExercise.builder()
                .exerciseName(faker.rockBand().name())
                .build();
    }
}
