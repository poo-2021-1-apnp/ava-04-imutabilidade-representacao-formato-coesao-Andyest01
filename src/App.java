import java.lang.Math;
import model.Time;


class App {
  public static void main(String[] args) {
    Time t1 = new Time();
    // representação string, padrão 00:00:00
    System.out.println(t1.toString().equals("00:00:00"));
    Time t2 = new Time(1, 40, 5);
    System.out.println(t2.toString().equals("01:40:05"));
    Time t3 = t1.plus(t2);
    System.out.println(t3.toString().equals("01:40:05"));
    System.out.println(t3.hours() == 1);
    System.out.println(t3.minutes() == 40);
    System.out.println(t3.seconds() == 5);
    // deve ser imutável
    System.out.println(t1.hours() == 0);
    System.out.println(t1.minutes() == 0);
    System.out.println(t1.seconds() == 0);
    // plus
    Time t4 = t3.plus(t2);
    System.out.println(t4.toString().equals("03:20:10"));
    // implementar equals
    System.out.println(t4.equals(new Time(3, 20, 10)));
    Time t5 = t2.plusHours(1);
    System.out.println(t5.toString().equals("02:40:05"));
    Time t6 = t4.plusHours(23);
    System.out.println(t6.toString().equals("02:20:10"));
    Time t7 = t6.plusMinutes(10);
    System.out.println(t7.toString().equals("02:30:10"));
    Time t8 = t7.plusSeconds(80);
    System.out.println(t8.toString().equals("02:31:30"));
    Time t9 = new Time(0,-61,-10);
    System.out.println(t9.toString());
    Time t10 = t9.plusHours(-1).plusMinutes(-1).plusSeconds(-1);
    System.out.println(t10.toString());//.equals("18:22:17"));
    Time t11 = t10.minusHours(2).minusMinutes(2).minusSeconds(2);
    System.out.println(t11.toString());//.equals("16:20:15"));
    Time t12 = t11.minusHours(-5);
    System.out.println(t12.toString());//.equals("21:20:15"));
    Time t13 = t11.minus(t12);
    System.out.println(t13.toString().equals("19:00:00"));


    int t = -25;
    System.out.println((Math.abs(t) >= 24)? t % 2 : t);
  }
}
