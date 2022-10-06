import lombok.*;
import org.json.JSONObject;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString

public class User {
    int id;
    int grade;

    public static User of(JSONObject jsonObject){
        return User.builder().id(jsonObject.getInt("id"))
                .grade(jsonObject.getInt("grade"))
                .build();
    }
}
