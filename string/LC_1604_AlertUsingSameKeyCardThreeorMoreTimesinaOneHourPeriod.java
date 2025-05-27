package string;

import java.util.*;

public class LC_1604_AlertUsingSameKeyCardThreeorMoreTimesinaOneHourPeriod {

    private static int convertToMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    public static List<String> alertNames(String[] keyName, String[] keyTime) {
        HashMap<String, List<Integer>> nameMap = new HashMap<>();

        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            String time = keyTime[i];
            int minutes = convertToMinutes(time);

            if (!nameMap.containsKey(name)) {
                nameMap.put(name, new ArrayList<>());
            }
            nameMap.get(name).add(minutes);
        }

        List<String> output = new ArrayList<>();

        for (Map.Entry<String, List<Integer>> elements : nameMap.entrySet()) {
            List<Integer> times = elements.getValue();
            Collections.sort(times);

            for (int i = 2; i < times.size(); i++) {
                if (times.get(i) - times.get(i - 2) <= 60) {
                    output.add(elements.getKey());
                    break;
                }
            }
        }

        Collections.sort(output);
        return output;
    }

    public static void main(String[] args) {
        // Test Case 1: Basic alert case
        String[] names1 = {"daniel","daniel","daniel","luis","luis","luis","luis"};
        String[] times1 = {"10:00","10:40","11:00","09:00","11:00","13:00","15:00"};
        System.out.println("Test 1: " + alertNames(names1, times1)); // [daniel]

        // Test Case 2: No alerts
        String[] names2 = {"alice","bob","charlie"};
        String[] times2 = {"10:00","10:30","11:00"};
        System.out.println("Test 2: " + alertNames(names2, times2)); // []

        // Test Case 3: Multiple alerts
        String[] names3 = {"a","a","a","b","b","b","b"};
        String[] times3 = {"09:00","09:20","09:40","10:00","10:30","11:00","11:30"};
        System.out.println("Test 3: " + alertNames(names3, times3)); // [a, b]

        // Edge Case 1: Same time entries
        String[] names4 = {"alex","alex","alex"};
        String[] times4 = {"12:00","12:00","12:00"};
        System.out.println("Test 4: " + alertNames(names4, times4)); // [alex]

        // Edge Case 2: Only two uses
        String[] names5 = {"carol","carol"};
        String[] times5 = {"15:00","15:59"};
        System.out.println("Test 5: " + alertNames(names5, times5)); // []
    }
}
