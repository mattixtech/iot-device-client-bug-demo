package org.example;

import com.microsoft.azure.sdk.iot.device.DeviceClient;
import com.microsoft.azure.sdk.iot.device.IotHubClientProtocol;

import java.io.IOException;
import java.net.URISyntaxException;

public class Example {
    private static final IotHubClientProtocol protocol = IotHubClientProtocol.AMQPS;
    private static final long delayMs = 100L;

    public static void main(String[] args) throws URISyntaxException, InterruptedException, IOException {
        DeviceClient demoClient = new DeviceClient(args[0], protocol);
        while(true) {
            try {
                System.out.println("Attempting to open connection...");
                demoClient.open();
                System.out.println("Connected... exiting");
                break;
            } catch (Exception e) {
                System.out.println("Failed to open, retrying...");
                demoClient.closeNow();
            }
            Thread.sleep(delayMs);
        }
    }
}
