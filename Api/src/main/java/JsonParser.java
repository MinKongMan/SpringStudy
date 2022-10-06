import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonParser {
    public ArrayList<Wait> getWait(JSONObject responseJson){
        ArrayList<Wait> trucks = new ArrayList<>();
        try{
            JSONArray trucksArray = responseJson.getJSONArray("trucks");
            for(int i = 0 ; i < trucksArray.length() ; i ++){
                JSONObject truckObject = trucksArray.getJSONObject(i);
                trucks.add(Wait.of(truckObject));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return trucks;
    }

    public ArrayList<User> getUser(JSONObject responseJson){
        ArrayList<User> trucks = new ArrayList<>();
        try{
            JSONArray trucksArray = responseJson.getJSONArray("user_info");
            for(int i = 0 ; i < trucksArray.length() ; i ++){
                JSONObject truckObject = trucksArray.getJSONObject(i);
                trucks.add(User.of(truckObject));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return trucks;
    }

    public ArrayList<User> getUser(JSONObject responseJson){
        ArrayList<User> trucks = new ArrayList<>();
        try{
            JSONArray trucksArray = responseJson.getJSONArray("user_info");
            for(int i = 0 ; i < trucksArray.length() ; i ++){
                JSONObject truckObject = trucksArray.getJSONObject(i);
                trucks.add(User.of(truckObject));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return trucks;
    }

    public ArrayList<Location> getLocations(JSONObject responseJson){
        ArrayList<Location> locations = new ArrayList<>();
        try{
            JSONArray locationsArray = responseJson.getJSONArray("locations");
            for(int i = 0 ; i < locationsArray.length() ; i ++){
                JSONObject locationObject = locationsArray.getJSONObject(i);
                locations.add(Location.of(locationObject));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return locations;
    }

    public double getScore(JSONObject responseJson){
        try{
            return responseJson.getDouble("score");
        } catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public JSONArray getCommandJSONArray(ArrayList<Command> commandsList){
        JSONArray commandArray = new JSONArray();
        for(Command commands : commandsList) commandArray.put(commands.getJSONObject());
        return commandArray;
    }

    public Simulation putSimulation(JSONObject responseJson){
        Simulation simulation = null;
        try{
            simulation = Simulation.of(responseJson);
        } catch (Exception e){
            e.printStackTrace();
        }
        return simulation;
    }
}
