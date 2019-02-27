package by.pr.basicsoapconsumer;

import org.example.ticketagent.TFlightsResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BasicSoapConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicSoapConsumerApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(TicketAgentClient ticketAgentClient) {
        return args -> {

            for (int i = 0; i < 20; i++) {
                System.out.println(ticketAgentClient.listFlights().get(0));
                Thread.sleep(2000);
            }
        };
    }

}
