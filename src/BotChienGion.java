import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class BotChienGion extends Material implements ChietKhau {

    public static final int EXP_DAY=365;

    public BotChienGion() {
    }

    public BotChienGion(String materialID, String materialName, String materialMFGDate, int quantity, double cost) {
        super(materialID, materialName, materialMFGDate, quantity, cost);
    }

    @Override
    protected double makePrice() {
        return getCost()*getQuantity();
    }

    @Override
    protected String makeEXP() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date now = simpleDateFormat.parse(getMaterialMFGDate());
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(now);
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH);
        int day=calendar.get(Calendar.DAY_OF_MONTH);
        LocalDate localDate= LocalDate.of(year,month,day);
        localDate = localDate.plusDays(EXP_DAY);
        return localDate.getDayOfMonth()+"/"+localDate.getMonthValue()+"/"+localDate.getYear();

    }
    @Override
    public double makeDiscount() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date productDate = simpleDateFormat.parse(getMaterialMFGDate());
        Date today=new Date();
        long diffDay= (today.getTime()-productDate.getTime())/(24*60*60*1000);

        if ((EXP_DAY-diffDay)<=60){
            return makePrice()*(100-40)/100;
        } else if (EXP_DAY-diffDay<=120){
            return makePrice()*(100-20)/100;
        } else {
            return makePrice()*(100-5)/100;
        }

    }



}
