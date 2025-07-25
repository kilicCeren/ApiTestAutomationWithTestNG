package pojos;

public class PojoHerokuappBookingdates {

    //1) Tum variable’lari "private" olarak olusturalim

    //2) Tum variable’lar icin getter( ) and setter( ) metodlari olusturalim

    //3-) Tum parametreleri iceren bir constructor olusturalim

    //4) Default constructor yerine manuel olarak (parametresiz) constructor olusturalim

    //5) toString( ) metodu olusturalim


    /*
    "bookingdates" : {
                    "checkin" : "2021-06-01",
                    "checkout" : "2021-06-10"
                    },
     */

    // 1- tum variable'lari private olarak olustur

    private  String checkin;
    private  String checkout;

    // 2- tum variable'lar icin getter ve setter metodlari olusturalim

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }


    // 3- tum parametreleri kullanarak bir constructor olusturalim

    public PojoHerokuappBookingdates(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }


    // 4- default constructor yerine manuel olarak parametresiz bir constructor olusturalim

    public PojoHerokuappBookingdates() {
    }


    // 5- toString metodu olusturalim


    @Override
    public String toString() {
        return "PojoHerokuappBookingdates{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}