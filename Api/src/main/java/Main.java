import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static int centerR = 2;
    static int centerC = 2;
    private static class Pair{
        int r;
        int c;

        Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    private static class competition implements Comparable<competition>{
        User user;
        int time;
        competition(User user, int time){
            this.user = user;
            this.time = time;
        }

        @Override
        public int compareTo(competition o) {
            return this.time-o.time;
        }
    }
    private static JsonParser jsonParser = new JsonParser();
    private static int[] array;

//    private static ArrayList<Wait> trucks(){
//        return jsonParser.getWait()
//    }
//
//    private static ArrayList<Location> locations(){
//        return jsonParser.getLocations(Connection.getInstance().locations());
//    }




//    private static double score(){
//        System.out.println("##### result #####");
//        JSONObject jsonObject = Connection.getInstance().score();
//        return jsonParser.getScore(jsonObject);
//    }
//
//    private static String simulate(ArrayList<Command> commands){
//        JSONObject jsonObject = Connection.getInstance().simulate(jsonParser.getCommandJSONArray(commands));
//        Simulation simulation = jsonParser.putSimulation(jsonObject);
//        return simulation.toString();
//    }

    private static String start(int problemId){
        return TokenManager.getInstance().createToken(problemId);
    }


    public static void main(String[] args) {
        int problemId = 1;
        String response = start(problemId);
        if(response.equals("200")){
            array = new int[31];
            int time = 0;
            ArrayList<User> user = jsonParser.getUser(Connection.getInstance().User());
            System.out.println(user+" ");
//            while(time++ < 595){
//                ArrayList<Location> locations = locations();
//                ArrayList<Truck> trucks = trucks();
//                List<Integer> trucksIdx = trucks.stream().map(Truck::getLoaded_bikes_count).collect(Collectors.toList());
//                ArrayList<Integer> load = new ArrayList<>();
//                load.add(5);
//                ArrayList<Integer> unload = new ArrayList<>();
//                load.add(6);
//                ArrayList<Command> commands = new ArrayList<>();
//
//
//                if(time % 50 == 1){
//                    for(int i = 0 ; i < 5 ; i ++){
//                        List<Integer> joined = new ArrayList<>(List.of(6, 6, 6, 6, 6, 6, 6, 6, 6, 6));
//                        commands.add(new Command(i, joined));
//                    }
//                }
//                else for(int i = 0 ; i < 5 ; i ++){
//                    List<Integer> joined = new ArrayList<>();
//                    joined.addAll(load);
//                    joined.addAll(getRoute(map.get(trucksIdx.get(i)).r, map.get(trucksIdx.get(i)).c, map.get(leastPlaces.get(i)).r, map.get(leastPlaces.get(i)).c, locations));
//                    joined.addAll(unload);
//                    commands.add(new Command(i, joined));
//                }
//                System.out.println(simulate(commands));
//            }
//            System.out.println(score());
        }
    }
}