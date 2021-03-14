package model;
import model.util.TimeManager;
import static java.lang.Integer.parseInt;

public class Time {
  private final int seconds;
  public static final Time MIDDAY = new Time(12, 0);
  public static final Time MIDNIGHT = new Time();

  public Time() {
    this(0, 0, 0);
  }

  public Time(int h, int m) {
    this(h, m, 0);
  }

  public Time(int h, int m, int s) {
    this.seconds = TimeManager.checkTimeOverflow(h, m, s);
  }

  public static Time fromString(String time) {
    return new Time(getHoursFromString(time), getMinutesFromString(time), getSecondsFromString(time));
  }

  // "01234567"
  // "01:36:00"
  public static int getHoursFromString (String time) {
    return parseInt(time.substring(0, 2));
  }

  public static int getMinutesFromString(String time) {
    return parseInt(time.substring(3, 5));
  }

  public static int getSecondsFromString(String time) {
    return parseInt(time.substring(6, 8));
  }

  public static Time from(Time time) {
    // Time
    return time;
  }

  public static Time fromSeconds(int time) {
    // 64021
    return new Time(0, 0, time);
  }

  public static Time fromDouble(double time) {
    // 3.824
    return fromSeconds(TimeManager.hoursToSeconds(time));
  }

  public int hours() {
    return TimeManager.secondsToHours(this.seconds);
  }

  public int minutes() {
    return TimeManager.secondsToMinutes(this.seconds);
  }

  public int seconds() {
    return TimeManager.secondsToSeconds(this.seconds);
  }

  public int toInt() {
    return this.seconds;
  }

  // "00:00:00"
	public String toString() {
		return (String.format("%02d:%02d:%02d", this.hours(), this.minutes(), this.seconds()));
	}

  public String toLongString() {
    String time;
    if (this.hours() > 0) {
      time = this.hours() + " hora";
      if (this.hours() != 1) time += "s";
    } else {
      time = "Meia noite ";
    }

    if (this.minutes() > 0) {
      if (this.seconds() ==0)
        time += " e";

      time += " " + this.minutes() + " minutos";
    }

    if (this.seconds() > 0) {
      time += " e " + this.seconds() + " segundos";
    }
    return time;
  }

  public String toShortString () {
    String time = (String.format("%02dh", this.hours()));

    if ((this.minutes() == 0) && (this.seconds() == 0))
        return time;

    time += (String.format("%02dm", this.minutes()));

    if (this.seconds() > 0)
      time += (String.format("%02ds", this.seconds()));

    return time;
  }

  public Double toDouble() {
    return (TimeManager.secondsToDoubleHours(this.seconds));
  }

  public Time plus(Time t2) {
    return fromSeconds(this.toInt()+t2.toInt());
  }

  public Time plusHours(int h) {
    return this.plus(new Time(h, 0, 0));
  }

  public Time plusMinutes(int m) {
    return this.plus(new Time(0, m, 0));
  }

  public Time plusSeconds(int s) {
    return this.plus(new Time(0, 0, s));
  }

  public Time minus (Time t2) {
    return fromSeconds(this.toInt() - t2.toInt());
  }

  public Time minusHours(int h) {
    return this.plusHours(-h);
  }

  public Time minusMinutes(int m) {
    return this.plusMinutes(-m);
  }

  public Time minusSeconds(int s) {
    return this.plusSeconds(-s);
  }

  public boolean isMidDay() {
    return this.equals("12:00:00");
  }

  public boolean isMidNight() {
    return this.equals("00:00:00");
  }

  public Time shift() {
    return this.plusHours(12);
  }

  public Time tick() {
    return this.plusSeconds(1);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (null == o) return false;

    if (o instanceof String){
      String objString = (String) o;

      if (objString.equals(this.toString()) ||
          objString.equals(this.toLongString())) {
        return true;
      }
    }

    if (!(o instanceof Time))
      return false;

    Time time2 = (Time) o;
    return (this.toInt() == time2.toInt());
  }

  @Override
  public int hashCode() { ///////////////////////////////////////////////////////////
    // TODO Auto-generated method stub
    return super.hashCode();
  }
}
