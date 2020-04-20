import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;

    public class LoaJavaDate {
    public static void main(String[] args) throws ParseException {
//        Long nowOther=System.currentTimeMillis();
//        Date now= new Date();
//        Date affter_1year= new Date(nowOther+(24*60*60*1000*365L));
//        System.out.println(now);
//        System.out.println(affter_1year);
//        Date now = new Date();
//        SimpleDateFormat  simpleDateFormat= new SimpleDateFormat(" E dd/MM/yy hh:mm:ss SSS z");
//        String myTime = simpleDateFormat.format(now);
//        System.out.println(myTime);
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd/MM/yyyy");
        String input ="27/09/2019";
        Date now = simpleDateFormat.parse(input);
        System.out.println(simpleDateFormat.format(now));
//        Calendar calendar=Calendar.getInstance();
//        calendar.setTime(now);
//                int year = calendar.get(Calendar.YEAR);
//            int month=calendar.get(Calendar.MONTH);
//        int day = calendar.get(Calendar.DAY_OF_MONTH);
        Date date= new Date();
        System.out.println((date.getTime()-now.getTime())/(60 * 60 * 1000*24));

        System.out.println(date.before(now));
//        int year = calendar.get(Calendar.YEAR);
//        int month=calendar.get(Calendar.MONTH);
//        int day = calendar.get(Calendar.DAY_OF_MONTH);
//
//        LocalDate localDate= LocalDate.of(year,month,day);
//        System.out.println(localDate);
//        localDate= localDate.plusDays(365);
//        System.out.println(localDate);

    }
}
