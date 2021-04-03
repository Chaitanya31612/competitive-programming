public class OurMapUse {
    public static void main(String[] args) {
        Map<String, Integer> map = new Map<>();
        for(int i = 0; i < 20; i++) {
            map.insert("a" + i, i+1);
            System.out.println("i = " + i + " lf = " + map.loadFactor());
        }

        map.removeKey("a3");
        map.removeKey("a9");

        for(int i = 0; i < 20; i++) {
            System.out.println("a" + i + ": " + map.getValue("a" + i));
        }
    }
}
