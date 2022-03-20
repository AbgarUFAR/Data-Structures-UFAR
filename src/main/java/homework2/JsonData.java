package homework2;

import com.google.gson.Gson;

import java.util.Date;
import java.util.Random;

public class JsonData {
    public static void main(String[] args) {
        CartesianCoordinate[] coordinates = new CartesianCoordinate[1000];
        long now = new Date().getTime();
        Random rand = new Random();
        for (int i = 0; i < coordinates.length; i++) {
            int randomFrequency = rand.nextInt(5 - 1 + 1) + 1; // ((right - left + 1) - 1) -> [1, 5]
            coordinates[i] = new CartesianCoordinate();
            coordinates[i].x = now - 300_000 * i;
            coordinates[i].y = i + randomFrequency * Math.sin(i * 2 * Math.PI / coordinates.length);
        }
        Gson gson = new Gson();
        System.out.println(gson.toJson(coordinates));
    }
}
