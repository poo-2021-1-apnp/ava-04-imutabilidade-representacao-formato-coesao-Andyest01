package model.util;

public final class TimeManager {
  static final double INVERSE_MINUTE = 1.0D / TimeConstants.MINUTES.seconds;
  static final double INVERSE_HOUR = 1.0D / TimeConstants.HOURS.seconds;
  static final int HOURS_PER_DAY = 24;
  // Divide only once

  private TimeManager ()
  {} // Just to avoid default public class from being called elsewhere

  public static int hoursToSeconds (int h) {
    return h * TimeConstants.HOURS.seconds;
  }

  public static int hoursToSeconds(double h) {
    return (int) (h * TimeConstants.HOURS.seconds);
  }

  public static int minutesToSeconds (int m) {
    return m * TimeConstants.MINUTES.seconds;
  }

  public static int secondsToHours (int s) {
    return (int) (s * INVERSE_HOUR);
  }

  public static int secondsToMinutes(int s) {
    return (int) ((s % TimeConstants.HOURS.seconds) * INVERSE_MINUTE);
  }

  public static int secondsToSeconds (int s) { // loved this name
    return s % TimeConstants.MINUTES.seconds;
  }

  public static double secondsToDoubleHours (int s) {
    return (s * INVERSE_HOUR);
  }

  public static int checkTimeOverflow(int h, int m, int s) {
    int seconds = hoursToSeconds(h) + minutesToSeconds(m) + s;

    if (Math.abs(seconds) >= TimeConstants.DAYS.seconds)
      seconds = seconds % TimeConstants.DAYS.seconds;

      if (seconds < 0) seconds = TimeConstants.DAYS.seconds + seconds;

    return seconds;

  }

                                                        // DELETE THIS \/
  public static int twentyFourOverflow (int h) {
    if (-HOURS_PER_DAY > h)
      return (h % HOURS_PER_DAY);

    if (0 > h)
      return HOURS_PER_DAY - h;

    if (h >= HOURS_PER_DAY)
      return (h % HOURS_PER_DAY);

    return h;
  }

  public static int sixtyOverflow (int n) {
    if (-TimeConstants.MINUTES.seconds > n)
      return (n % TimeConstants.MINUTES.seconds);

    if (0 > n)
      return TimeConstants.MINUTES.seconds - n;

    if (n >= TimeConstants.MINUTES.seconds)
      return (n % TimeConstants.MINUTES.seconds);

    return 0;

  }



}
