package com.example.producingwebservice;


import io.spring.guides.gs_producing_web_service.GetFriendRequest;
import io.spring.guides.gs_producing_web_service.GetFriendResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class FriendEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private FriendRepository friendRepository;

    @Autowired
    public FriendEndpoint(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getFriendRequest")
    @ResponsePayload
    public GetFriendResponse getFriend(@RequestPayload GetFriendRequest request) {
        GetFriendResponse response = new GetFriendResponse();
        response.setFriend(friendRepository.findFriend(request.getName()));

        return response;
    }


}