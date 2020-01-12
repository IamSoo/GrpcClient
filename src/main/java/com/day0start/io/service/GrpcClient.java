package com.day0start.io.service;

import com.day0start.io.grpc.Message;
import com.day0start.io.grpc.userGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {

    private static final int SERVER_PORT = 9090;

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",SERVER_PORT)
                .usePlaintext()
                .build();

        userGrpc.userBlockingStub userstub = userGrpc.newBlockingStub(channel);
        Message.request req = Message.request.newBuilder().setUsername("Soonam").build();
        Message.response resp =  userstub.hello(req);
        System.out.println(resp.getReply());
    }

}
