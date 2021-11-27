import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dto.Car;
import dto.User;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws JsonProcessingException {

        ObjectMapper obj = new ObjectMapper();

        //입력 시작
        User user = new User();
        user.setName("강민광");
        user.setAge(28);

        Car car1 = new Car();
        car1.setName("K5");
        car1.setCarNumber("11가 1111");
        car1.setType("sedan");


        Car car2 = new Car();
        car2.setName("Q5");
        car2.setCarNumber("22가 2222");
        car2.setType("SUV");


        List<Car> list = Arrays.asList(car1, car2);
        user.setCars(list);


        System.out.println(user);

        //문자열에 user를 문자열로 형변환
        String json = obj.writeValueAsString(user);
        System.out.println(json);

        JsonNode jsonNode = obj.readTree(json); // 오브젝트에 접근하기 위해 JsonNode로 받아들임
        String _name = jsonNode.get("name").asText(); // get으로 해당 값 접근
        int _age = jsonNode.get("age").asInt();
        System.out.println(_name+" "+_age);

        // 위는 Json의 이름, 나이를 가져왔음
        // 밑은 cars배열을 가져올 예정
        JsonNode cars = jsonNode.get("cars");
        ArrayNode arraysNode = (ArrayNode) cars; // 타입 변환(오브젝트가 배열일 경우)

        //파싱 과정(오브젝트를 넣고 우리가 원하는 타입을 넣어서 매핑)
        List<Car> _cars = obj.convertValue(arraysNode, new TypeReference<List<Car>>() {
        });// Object(arraysNode)를 받아서 우리가 원하는 타입(리스트에 Car가 들어간)리스트 형태로 변환을 시켜줄 거임 -> _cars로 받음
        System.out.println(_cars);


        ObjectNode objectNode = (ObjectNode) jsonNode; // 변경을 위한 작업(Json쪽에선 변경을 못하도록 막아놔서 ObjectNode로 해야함)
        objectNode.put("name", "KMK");


        System.out.println(objectNode.toPrettyString());
    }
}
