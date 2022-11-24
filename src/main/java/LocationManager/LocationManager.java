import java.util.*;

public class LocationManager {
    private Scanner scanner = new Scanner(System.in);
    private HashMap<String, Location> dept = new HashMap<>();

    private void read() {
        System.out.println("도시 이름, 경도, 위도를 입력하시오: ");
        while(true) {
            System.out.print(">> ");
            String inputText = scanner.nextLine();
            if(inputText.trim().equals("그만")) {
                break;
            }
            StringTokenizer st = new StringTokenizer(inputText, ", ");
            try {
                String cityName = st.nextToken().trim();
                double longitude = Double.parseDouble(st.nextToken().trim());
                double latitude = Double.parseDouble(st.nextToken().trim());
                dept.put(cityName, new Location(cityName, longitude, latitude));
            }
            catch(java.util.NoSuchElementException e) {
                System.out.println("잘못 입력했습니다.");
            }
            catch(NumberFormatException e) {
                System.out.println("숫자가 잘못 입력되었습니다.");
            }
        }
    }
    private void printAll() {
        var keys = dept.keySet();
        var iterator = keys.iterator();
        System.out.println("--------------------------------");
        while(iterator.hasNext()) {
            System.out.println(dept.get(iterator.next()));
        }
        System.out.println("--------------------------------");
    }

    private void processQuery() {  // 검색
        while(true) {
            System.out.print("도시 >> ");
            String name = scanner.nextLine();
            if(name.equals("그만")) {
                break;
            }
            if(name.equals("그만")) {
                printAll();
            } else {
                Location loc = dept.get(name);
                if(loc == null) {
                    System.out.println("없습니다.");
                    System.out.print("경도, 위도 >> ");
                    String lola = scanner.nextLine();

                    try {
                        StringTokenizer st = new StringTokenizer(lola, ", ");
                        double longitude = Double.parseDouble(st.nextToken().trim());
                        double latitude = Double.parseDouble(st.nextToken().trim());
                        dept.put(name, new Location (name, longitude, latitude));
                    }
                    catch(Exception e) {
                        System.out.println("잘못 입력했습니다.");
                    }
                }
                System.out.println(loc);
            }
        }
    }

    public void run() {
        read();
        printAll();
        processQuery();
    }
}