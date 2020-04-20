import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
       Material [] materials= new Material[10];
       // public BotChienGion(String materialID, String materialName, String materialMFGDate, int quantity, double cost)
       materials[0]=new BotChienGion("FR001","chiendonga1","22/06/2019",1,12000);
       materials[1]=new BotChienGion("FR002","chiendonga2","28/05/2019",3,13000);
       materials[2]=new BotChienGion("FR003","chiendonga3","22/05/2019",2,14000);
       materials[3]=new BotChienGion("FR004","chiendonga4","22/09/2019",5,15000);
       materials[4]=new BotChienGion("FR005","chiendonga5","22/01/2020",6,16000);
       materials[5]=new Thit("ME005","thit bo than","10/04/2020",1,12000,"gram",68000);
       materials[6]=new Thit("ME006","thit bo gan","11/04/2020",1,12000,"gram",68000);
       materials[7]=new Thit("ME007","thit lon mong","15/04/2020",1,12000,"kg",65);
       materials[8]=new Thit("ME008","thit chan gio","17/04/2020",1,12000,"kg",100);
       materials[9]=new Thit("ME009","xuong","08/04/2020",1,12000,"kg",70);

//Chenh lenh chiet khau
        for (Material material:materials){
            if (material instanceof ChietKhau){
                ChietKhau chietKhau = (ChietKhau)material;
                double diffPrice=material.makePrice()-chietKhau.makeDiscount();
                System.out.println("Chenh lenh giua gia chiet khau va khong chiet khau la : "+diffPrice+"VND"
                        + "{Nomal price: "+material.makePrice()+", discountPrice: "+chietKhau.makeDiscount()+ ", ty le chiet khau: "
                        +diffPrice*100/material.makePrice()+"}");
            }


        }

    }
}
