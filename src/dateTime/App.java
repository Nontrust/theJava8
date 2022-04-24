package dateTime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/*
 * Date 클래스는 mutable 하기 때문에 thread safe하지 않음
 * 기계용 시간 / 사람용 시간
 */
public class App {
	public static void main(String args) throws InterruptedException{
		Date date = new Date();
		long time = date.getTime();
		
		//month를 8로 쓰면 7월으로 나옴
		Calendar choongHoBirthDay = new GregorianCalendar(1995,Calendar.AUGUST,4);
		
		
		
		//Calendar calendar = new GregorianCalendar();
		//SimpleDateFormat dateFormat = new SimpleDateFormat();
		
		
	}
}
