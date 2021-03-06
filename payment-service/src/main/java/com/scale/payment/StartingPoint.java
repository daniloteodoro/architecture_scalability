package com.scale.payment;

public class StartingPoint {

    public static void main(String[] args) {
        try {
            String protocol = System.getenv().getOrDefault("PROTOCOL", "REACTIVE_REST");
            int paramPort = args.length > 0 ? Integer.parseInt(args[0]) : 8100;

            if ("REACTIVE_REST".equalsIgnoreCase(protocol)) {
                PaymentAppUsingReactiveREST.defaultSetup()
                        .startOnPort(paramPort, true);
            } else if ("REST".equalsIgnoreCase(protocol)) {
                PaymentAppUsingREST.defaultSetup()
                        .startOnPort(paramPort);
            } else {
                PaymentAppUsingGRPC.defaultSetup()
                        .startOnPort(paramPort, true);
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
            System.exit(1);
        }
    }

}
