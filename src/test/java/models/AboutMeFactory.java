package models;

import com.github.javafaker.Faker;

public class AboutMeFactory {

    static Faker faker = new Faker();

    public static AboutMe get(){
        return AboutMe.builder()
                .t1(faker.address().city())
                .t2(faker.job().title())
                .t3(faker.programmingLanguage().name())
                .t4(faker.chuckNorris().fact())
                .t5(faker.chuckNorris().fact())
                .t6(faker.chuckNorris().fact())
                .t7(faker.chuckNorris().fact())
                .t8(faker.chuckNorris().fact())
                .t9(faker.chuckNorris().fact())
                .t10(faker.music().genre())
                .t11(faker.cat().name())
                .t12(faker.cat().name())
                .t13(faker.cat().name())
                .t14(faker.cat().name())
                .t15(faker.cat().name())
                .build();
    }
}
