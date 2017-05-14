/*
    회비데이터에 접근하기위한 데이터 객체들
 */
package BackGround;

public class MfsDTO {

    private int price, paymoney, notpaymoney;
    private String mydate, membername, memo, remarks;

    public String getMembername() {
        return membername;
    }

    public void setMembername(String membername) {
        this.membername = membername;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPaymoney() {
        return paymoney;
    }

    public void setPaymoney(int paymoney) {
        this.paymoney = paymoney;
    }

    public int getNotpaymoney() {
        return notpaymoney;
    }

    public void setNotpaymoney(int notpaymoney) {
        this.notpaymoney = notpaymoney;
    }

    public String getMydate() {
        return mydate;
    }

    public void setMydate(String mydate) {
        this.mydate = mydate;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    
    
}
