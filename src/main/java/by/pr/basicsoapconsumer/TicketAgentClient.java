package by.pr.basicsoapconsumer;

import org.example.ticketagent.ObjectFactory;
import org.example.ticketagent.TFlightsResponse;
import org.example.ticketagent.TListFlights;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

import javax.xml.bind.JAXBElement;
import java.math.BigInteger;
import java.util.List;

@Component
public class TicketAgentClient {

    @Autowired
    private WebServiceTemplate webServiceTemplate;

    @SuppressWarnings("unchecked")
    public List<BigInteger> listFlights() {
        ObjectFactory factory = new ObjectFactory();
        TListFlights tListFlights = factory.createTListFlights();

        JAXBElement<TListFlights> request = factory.createListFlightsRequest(tListFlights);

        JAXBElement<TFlightsResponse> response =
                (JAXBElement<TFlightsResponse>) webServiceTemplate.marshalSendAndReceive(request);

        return response.getValue().getFlightNumber();
    }
}
