public class Location {
    private String name;
    private double longitude;  // 경도
    private double latitude;  // 위도

    public Location(String name, double longitude, double latitude) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
    }
    public String toString() {
        return name + "\t\t" + longitude + ", " + latitude;
    }
}