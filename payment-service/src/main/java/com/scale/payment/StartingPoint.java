package com.scale.payment;

public class StartingPoint {

    public static void main(String[] args) {
        try {
            String protocol = System.getenv().getOrDefault("PROTOCOL", "GRPC");
            int paramPort = args.length > 0 ? Integer.parseInt(args[0]) : 8100;

            if ("REST".equalsIgnoreCase(protocol)) {
                PaymentAppUsingREST.defaultSetup()
                        .startOnPort(paramPort);
            } else {
                PaymentAppUsingGRPC.defaultSetup()
                        .startOnPort(paramPort, true);
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
            System.exit(-1);
        }
    }

}