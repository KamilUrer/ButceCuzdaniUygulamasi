
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author User
 */
public class Hesaplar {
    
    private String hesapNo, bakiye, borc;
    
    public Hesaplar() {
        hesap();
    }
    String[] hesapNumaralari;
    String[] hesapBakiye;
    String[] hesapBorc;
    Connection connection = null;
    VeriTabani veriTabani = new VeriTabani();
    Statement statement = null;
    ResultSet resultSet;
    String hesap_no = "";
    String hesap_bakiye = "";
    String hesap_borc = "";
    public void hesap(){
        try {
            
            connection = veriTabani.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM banka");

            while(resultSet.next()){
                //Değişkenlere veritabanının kolonlarından çektiğimiz bilgileri atıyoruz
                setHesapNo(resultSet.getString("hesap_no"));
                hesap_no += hesapNo + " ";
                setBakiye(resultSet.getString("bakiye"));
                hesap_bakiye += bakiye + " ";
                setBorc(resultSet.getString("borçlar"));
                hesap_borc += borc + " ";
            }
            hesapNumaralari = hesap_no.split(" ");
            hesapBakiye = hesap_bakiye.split(" ");
            hesapBorc = hesap_borc.split(" ");
            
        } catch (Exception e) {
        }
    }
    
    
    /**
     * @return the hesapNo
     */
    public String getHesapNo() {
        return hesapNo;
    }

    /**
     * @param hesapNo the hesapNo to set
     */
    public void setHesapNo(String hesapNo) {
        this.hesapNo = hesapNo;
    }

    /**
     * @return the bakiye
     */
    public String getBakiye() {
        return bakiye;
    }

    /**
     * @param bakiye the bakiye to set
     */
    public void setBakiye(String bakiye) {
        this.bakiye = bakiye;
    }

    /**
     * @return the borc
     */
    public String getBorc() {
        return borc;
    }

    /**
     * @param borc the borc to set
     */
    public void setBorc(String borc) {
        this.borc = borc;
    }
    
}
