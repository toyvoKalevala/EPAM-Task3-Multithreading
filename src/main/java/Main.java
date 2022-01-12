import utils.Parser;
import entity.Truck;
import entity.Trucks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        Parser parser = new Parser();
        String path = "src/main/resources/Trucks.json";
        Trucks trucks = parser.parse(path);

        ExecutorService service = Executors.newCachedThreadPool();
        for (Truck truck : trucks.getTracks()) {
            service.execute(truck);
        }
        service.shutdown();
    }
}
