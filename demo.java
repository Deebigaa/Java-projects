class Reservation {
    public int transactionNumber;
    public String ccategory;
    public String ccustomerName;


    public Reservation(String category, String customerName) {
        ccategory = category;
        ccustomerName = customerName;
    }

    public int getTransactionNumber() {        
        transactionNumber = transactionNumber + 1;
        return transactionNumber;        
    }
    public String getCategory() {
        return this.ccategory;
    }
    public String getCustomerName() {
        return this.ccustomerName;
    }
    public boolean validateCategory() {
        String category1 = this.ccategory.toLowerCase();
        if (category1.equals("train")) {
            return true;
        } else if (category1.equals("flight")) {
            return true;
        } else {
            return false;
        }
    }
}

class RailwayReservation extends Reservation {
    public String strainName;
    public int inumberOfTickets;
    public String sbookingClass;

    public RailwayReservation( String category,String customerName,String trainName,int numberOfTickets,String bookingClass) {
        super(category, customerName);
        strainName = trainName;
        inumberOfTickets = numberOfTickets;
        sbookingClass = bookingClass;
    }
    public String getTrainName() {
        return this.strainName;
    }
    public int getNumberOfTickets() {
        return this.inumberOfTickets;
    }
    public String getbookingClass() {
        return this.sbookingClass;
    }
    public void calculateAmount() {
        int amount = 0;
        int AmountPerTicket = 0;

        switch (this.sbookingClass.toUpperCase()) {
            case "AC1":
                AmountPerTicket = 1500;
                break;
            case "AC2":
                AmountPerTicket = 1100;
                break;
            case "AC3":
                AmountPerTicket = 700;
                break;
            default:
                break;          
        }
        amount = this.inumberOfTickets * AmountPerTicket;
        System.out.println ("Amount             :" + amount);
    }
}

class AirTicketReservation extends Reservation {
    String fflightName;
    int nnumberOfTickets;
    String bbookingClass;
    
    public AirTicketReservation(String category, String customerName, String flightName,int numberOfTickets, String bookingClass) {
        super(category, customerName);
        fflightName = flightName;
        nnumberOfTickets = numberOfTickets;
        bbookingClass = bookingClass;

    }
    public String getFlightName() {
        return this.fflightName;
    }
    int getNumberOfTickets() {
        return this.nnumberOfTickets;
    }
    public void calculateAmount() {
        int amount = 0;
        int AmountPerTicket = 0;

        switch (this.bbookingClass.toLowerCase()) {
            case "business":
                AmountPerTicket = 4500;
                break;
            case "economy":
                AmountPerTicket = 3500;
                break;
            default:
                break;          
        }
        amount = this.nnumberOfTickets * AmountPerTicket;
        System.out.println ("Amount             :" + amount);

    }
}

public class demo {
    public static void main (String[] args) {

        RailwayReservation objRailReservation = new RailwayReservation ( "train" ,"ashok","rajdhani",2,"AC2");
        // String category     = objRailReservation.ccategory;
        // String customerName = objRailReservation.ccustomerName;

        Reservation objReservation = new Reservation (objRailReservation.ccategory,objRailReservation.ccustomerName);
        objReservation.validateCategory();
        
        System.out.println ("Transaction Number :" + objReservation.getTransactionNumber());
        System.out.println ("Ticket Category    :" + objReservation.getCategory());
        System.out.println ("Customer Name      :" + objReservation.getCustomerName());
        System.out.println ("Train Name         :" + objRailReservation.getTrainName());	
        System.out.println ("Number of Tickets  :" + objRailReservation.getNumberOfTickets());	
        System.out.println ("Booking Class      :" + objRailReservation.getbookingClass());	
        objRailReservation.calculateAmount();

        System.out.println (" ");	
        System.out.println (" ");

        AirTicketReservation objAirTicketReservation = new AirTicketReservation ("flight","anjana","airINDIA",3,"economy");
        Reservation objReservation1 =  new Reservation (objAirTicketReservation.ccategory,objAirTicketReservation.ccustomerName);
        // category     = objAirTicketReservation.ccategory;
        // customerName = objAirTicketReservation.ccustomerName;        
        objReservation1.validateCategory();

        System.out.println ("Transaction Number :" + objReservation1.getTransactionNumber());
        System.out.println ("Ticket Category    :" + objReservation1.getCategory());
        System.out.println ("Customer Name      :" + objReservation1.getCustomerName());
        System.out.println ("Flight Name        :" + objAirTicketReservation.getFlightName());
        System.out.println ("Number of Tickets  :" + objAirTicketReservation.getNumberOfTickets());
        objAirTicketReservation.calculateAmount();
    }
}
