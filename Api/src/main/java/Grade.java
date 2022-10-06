import lombok.*;
import org.json.JSONObject;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Getter
@Setter
public class Grade {
    int id;
    int location_id;
    int loaded_bikes_count;

    public static Grade of(JSONObject jsonObject){
        return Grade.builder()
                .location_id(jsonObject.getInt("id"))
                .loaded_bikes_count(jsonObject.getInt("location_id"))
                .loaded_bikes_count(jsonObject.getInt("loaded_bikes_count"))
                .build();
    }
}