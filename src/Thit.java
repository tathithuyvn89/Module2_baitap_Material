import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Thit extends Material implements ChietKhau {
    private String unit;
    private double weight;
    public final int EXP_DAY=15;

    public Thit() {
    }

    public Thit(String materialID, String materialName, String materialMFGDate, int quantity, double cost, String unit, double weight) {
        super(materialID, materialName, materialMFGDate, quantity, cost);
        this.unit = unit;
        this.weight = weight;
    }

    public Thit(String unit, double weight) {
        this.unit = unit;
        this.weight = weight;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    protected double makePrice() {
       if( unit.equalsIgnoreCase("gram")){
           return getWeight()*getCost()/1000;
       } else {
           return getWeight()*getCost();
       }
    }

    @Override
    protected String makeEXP( ) throws ParseException {
        LocalDate localDate = getLocalDate();
        return localDate.getDayOfMonth()+"/"+localDate.getMonthValue()+"/"+localDate.getYear();

    }

    private LocalDate getLocalDate() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date productDate = simpleDateFormat.parse(getMaterialMFGDate());
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(productDate);
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH);
        int day=calendar.get(Calendar.DAY_OF_MONTH);
        LocalDate localDate= LocalDate.of(year,month,day);
        localDate = localDate.plusDays(EXP_DAY);
        return localDate;
    }

    @Override
    public double makeDiscount() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date productDate = simpleDateFormat.parse(getMaterialMFGDate());
        Date today=new Date();
        long diffDay= (today.getTime()-productDate.getTime())/(24*60*60*1000);

        if (diffDay<=3){
            return makePrice()*(100-50)/100;
        } else if (diffDay<=5){
            return makePrice()*(100-30)/100;
        } else {
            return makePrice()*(100-10)/100;
        }

    }

}
