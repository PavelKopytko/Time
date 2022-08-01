package by.epam.tr.time;

import java.util.Objects;

/* Составьте описание класса для представления времени. Предусмотрте возможности установки 
 * времени и изменения его отдельных полей (час, минута, секунда) с проверкой допустимости 
 * вводимых значений. В случае недопустимых значений полей поле устанавливается в значение 0. 
 * Создать методы изменения времени на заданное количество часов, минут и секунд*/

public class Time {

	private int hour;
	private int minute;
	private int seconds;

	public Time() {

	}

	public Time(int seconds) {
		if (isCorrect(seconds)) {
			this.seconds = seconds;
		}
	}

	public Time(int minute, int seconds) {
		this(seconds);
		if (isCorrect(minute)) {
			this.minute = minute;
		}

	}

	public Time(int hour, int minute, int seconds) {
		this(minute, seconds);
		if (hour >= 0 /* && hour < 24 */) {
			this.hour = hour;
		}
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		if (hour >= 0 /* && hour < 24 */) {
			this.hour = hour;
		}
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		if (isCorrect(minute)) {
			this.minute = minute;
		}
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSecond(int seconds) {
		if (isCorrect(seconds)) {
			this.seconds = seconds;
		}
	}

	public void addSeconds(int seconds) {
		if (seconds >= 0) {
			this.addMinute((this.seconds + seconds) / 60);
			this.seconds = (this.seconds + seconds) % 60;
		}
	}

	public void addMinute(int minute) {
		if (minute >= 0) {
			this.addHour((this.minute + minute) / 60);
			this.minute = (this.minute + minute) % 60;
		}
	}

	public void addHour(int hour) {
		if (hour >= 0) {
			this.hour += hour;
		}
	}

	public void add(int hour, int minute, int seconds) {
		addHour(hour);
		addMinute(minute);
		addSeconds(seconds);

	}

//	public void substractSeconds(int seconds) {
//		if (seconds >= 0) {
//			this.substractMinute((this.seconds + seconds) / 60);
////			this.seconds -= seconds % 60 - 60;
//			if (this.seconds - seconds < 0) {
//				this.seconds += 60 - seconds;
//				this.substractMinute(1);
//			} else {
//				this.seconds -= seconds % 60;
//			}
//		}
//		if (this.seconds < 0) {
//			this.seconds = 0;
//
//		}
//	}
//
//	public void substractMinute(int minute) {
//		if (minute > 0) {
//			this.substractHour((this.minute - minute) / 60);
//			if (this.minute - minute < 0) {
//				this.minute += 60 - minute;//
////				this.substractHour(1);
//			} else {
//				this.minute -= minute % 60;
//			}
//		}
//		if (this.minute < 0) {
//			this.minute = 0;
//			throw new RuntimeException("The value of minutes cannot be negative");
//		}
//	}
//
//	public void substractHour(int hour) {
//		if (hour >= 0 && this.hour - hour >= 0) {
//			this.hour -= hour;
//		}
//		if (this.hour < 0) {
//			this.hour = 0;
//			throw new RuntimeException("The value of hours cannot be negative");
//		}
//	}

	private boolean isCorrect(int a) {
		if (a >= 0 && a < 60) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(hour, minute, seconds);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		return hour == other.hour && minute == other.minute && seconds == other.seconds;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [hour=" + hour + ", minute=" + minute + ", seconds=" + seconds + "]";
	}

}
