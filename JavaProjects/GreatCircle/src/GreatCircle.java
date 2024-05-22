public class Main {
    public static void main(String[] args) {
         double x1 = Double.parseDouble(args[0]);
         double y1 = Double.parseDouble(args[1]);
         double x2 = Double.parseDouble(args[2]);
         double y2 = Double.parseDouble(args[3]);

         double radianX1 = Math.toRadians(x1);
         double radianY1 = Math.toRadians(y1);
         double radianX2 = Math.toRadians(x2);
         double radianY2 = Math.toRadians(y2);

         double distance = 60 * Math.acos(Math.sin(radianX1) * Math.sin(radianX2) + Math.cos(radianX1) * Math.cos(radianX2) * Math.cos(radianY1 - radianY2));

         double distance1 = Math.toDegrees(distance);

         System.out.println( distance1 + " nauticalmiles");

    }
}