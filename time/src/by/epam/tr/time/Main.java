package by.epam.tr.time;

public class Main {

	public static void main(String[] args) {

		TimeView view = new TimeView();

		Time first = new Time();

		first.setSecond(58);//

		view.print(first);

		first.addSeconds(3662);//

		view.print(first);

		first.addHour(5);//

		view.print(first);

		first.addMinute(58);//

		view.print(first);

		first.add(1, 59, 61);//

		view.print(first);

		first.addMinute(59);//

		view.print(first);

		first.addSeconds(59);//

		view.print(first);
		
		

	}

}
