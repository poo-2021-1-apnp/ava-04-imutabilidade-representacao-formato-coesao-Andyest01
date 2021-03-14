package model.util;

enum TimeConstants {

  DAYS (86400),
  HOURS (3600),
  MINUTES (60);

  final int seconds;

  TimeConstants(int seconds) {
    this.seconds = seconds;
  }
}
