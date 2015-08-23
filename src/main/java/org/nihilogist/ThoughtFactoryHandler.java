package org.nihilogist;


import mongrel2.HttpRequest;
import mongrel2.HttpResponse;
import mongrel2.HttpStatus;
import mongrel2.Mongrel2Handler;
import org.nihilogist.thoughts.ThoughtFactory;
import org.nihilogist.thoughts.ThoughtGenerator;

import java.io.IOException;

public class ThoughtFactoryHandler {

    private static final String SERVICE_NAME = "thought-service";
    private static final String RECEIVE_ADDRESS = "tcp://mongrel2:5557";
    private static final String SEND_ADDRESS = "tcp://mongrel2:5558";

    public static void main(String[] args) {
        logToConsole("process firing up.");

        ThoughtFactory thoughtFactory = new ThoughtGenerator();
        logToConsole("Thought Factory initialised.");

        Mongrel2Handler handler = new Mongrel2Handler(SERVICE_NAME, RECEIVE_ADDRESS, SEND_ADDRESS);

        handler.setActive(true);
        while (handler.isActive()) {
            logToConsole("waiting for invocation.");
            HttpRequest req = new HttpRequest();
            HttpResponse rsp = new HttpResponse();
            handler.takeRequest(req); // wait until next request arrives
            logToConsole("received invocation message.");
            rsp.setContent(thoughtFactory.getThought().asJson() + "\n");
            rsp.setStatus(HttpStatus.OK);
            try {
                logToConsole("sending response message.");
                handler.sendResponse(rsp, req); // multiple requests may be given here
                logToConsole("response message sent.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    private static void logToConsole(String logMessage) {
        System.out.println("Thought for the day: " + logMessage);
    }
}
