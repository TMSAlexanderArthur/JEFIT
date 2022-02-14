package models;

import com.github.javafaker.Faker;

public class BodyStatsFactory {

    static Faker faker = new Faker();

    public static BodyStats get() {
        return BodyStats.builder()
                .weight(faker.number().digits(2).replace("0", ""))
                .bodyFat(faker.number().digits(2).replace("0", ""))
                .height(faker.number().digits(2).replace("0", ""))
                .chest(faker.number().digits(2).replace("0", ""))
                .waist(faker.number().digits(2).replace("0", ""))
                .arms(faker.number().digits(2).replace("0", ""))
                .shoulders(faker.number().digits(2).replace("0", ""))
                .foreams(faker.number().digits(2).replace("0", ""))
                .neck(faker.number().digits(2).replace("0", ""))
                .hips(faker.number().digits(2).replace("0", ""))
                .thighs(faker.number().digits(2).replace("0", ""))
                .calves(faker.number().digits(2).replace("0", ""))
                .build();
    }
}
