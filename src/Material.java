import java.text.ParseException;

public abstract class Material  {
    String materialID;
    String materialName;
    String materialMFGDate;
    int quantity;
    double cost;
    public Material(){

    }

    public Material(String materialID, String materialName, String materialMFGDate, int quantity, double cost) {
        this.materialID = materialID;
        this.materialName = materialName;
        this.materialMFGDate = materialMFGDate;
        this.quantity = quantity;
        this.cost = cost;
    }

    public String getMaterialID() {
        return materialID;
    }

    public void setMaterialID(String materialID) {
        this.materialID = materialID;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getMaterialMFGDate() {
        return materialMFGDate;
    }

    public void setMaterialMFGDate(String materialMFGDate) {
        this.materialMFGDate = materialMFGDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    protected abstract double makePrice();
    protected abstract String makeEXP() throws ParseException;

}
