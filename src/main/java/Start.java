import net.guard.passer.entity.App;
import net.guard.passer.entity.Ticket;
import net.guard.passer.parser.DateParser;
import net.guard.passer.parser.JacksonDataBind;
import net.guard.passer.parser.Percentile;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Start {
    public static void main(String[] args) {
        App app = JacksonDataBind.parseJson("C:\\Users\\Камиль\\IdeaProjects\\exp\\tickets-test\\src\\main\\resources\\tickets.json");

        //System.out.println(app.getTickets());
        ArrayList<Ticket> tickets = (ArrayList<Ticket>) app.getTickets();
        List<Integer> flightTime = new ArrayList<>(tickets.size());
        //Владивосток - UTC+10
        //Тель-Авив - UTC+3
        double sumMinutes = 0;
        for(int i = 0; i < tickets.size(); i++){
            LocalDateTime localDateTime1 = DateParser.parseDateTime(tickets.get(i).getDeparture_date(), tickets.get(i).getDeparture_time());
            LocalDateTime localDateTime2 = DateParser.parseDateTime(tickets.get(i).getArrival_date(), tickets.get(i).getArrival_time());
            long minutes = ChronoUnit.MINUTES.between(localDateTime1, localDateTime2);
            minutes+=7*60;
            flightTime.add((int) minutes);
            sumMinutes+=minutes;
        }
        flightTime.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("Среднее время полета: " + sumMinutes/tickets.size() + " мин");
        Percentile.fundingValue(90, flightTime);

    }


}
