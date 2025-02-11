
public class Main{
    public static void main(String[] args){
        // ArrayList<Attendee> attList = new ArrayList<Attendee>();
        // Attendee mrTwyford = new Attendee("Mr. Twyford", "Seven Hills", 7);
        // attList.add(mrTwyford);
        // System.out.println(attList.get(0).toString());
        Party p = new Party(10, 10);
        p.readFile();
        p.register();
        p.printCompanyList();
    }
}
