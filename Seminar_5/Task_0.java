import java.util.HashMap;
import java.util.Map;

public class Task_0 {
    public static void main(String[] args) {
        Map<String, String> employees = new HashMap<>();
        employees.put("123456", "Ivanov");
        employees.put("321456", "Vasiliev");
        employees.put("234561", "Petrova");
        employees.put("234432", "Ivanov");
        employees.put("654321", "Petrova");
        employees.put("345678", "Ivanov");

        String targetName = "Ivanov";
        for (Map.Entry<String, String> entry : employees.entrySet())
        {
            if(entry.getValue().equals(targetName))
            {
                System.out.println("Numarul pasaportului: " + entry.getKey() + ", Prenumele: " + entry.getValue());
            }
        }
    }
}