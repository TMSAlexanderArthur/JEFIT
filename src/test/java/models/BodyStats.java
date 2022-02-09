package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BodyStats {

    String weight;
    String bodyFat;
    String height;
    String chest;
    String waist;
    String arms;
    String shoulders;
    String foreams;
    String neck;
    String hips;
    String thighs;
    String calves;

}
